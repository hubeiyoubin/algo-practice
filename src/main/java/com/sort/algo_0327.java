package com.sort;

/**
 * @author yb
 * @date: 2021-2-18
 * 327 区间和的个数
 */
public class algo_0327 {

    /**
     * 暴力解法， O(n^2)
     * @param nums
     * @param lower
     * @param upper
     * @return
     */
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] sum = new long[nums.length + 1];
        for(int i = 1; i < sum.length; i ++){
            sum[i] = sum[i-1] + nums[i-1];
        }
        int count = 0;
        for(int i = 0; i < sum.length; i ++){
            for(int j = i +1; j < sum.length; j ++){
                long cha = sum[j] - sum[i];
                if(cha >= lower && cha <= upper)
                    count ++;
            }
        }
        return count;
    }
}
