package com.doublepointer;

/**
 * @author yb
 * @date: 2021-2-3
 * 1248 统计「优美子数组」
 */
public class algo_1248 {
    /**
     * 罗列所有奇数下标，外加 左右边界 -1， nums.length 便于计算
     * @param nums
     * @param k
     * @return
     */
    public int numberOfSubarrays(int[] nums, int k) {
        if(nums == null || nums.length == 0)
            return 0;
        // 储存所有奇数下标（假设所有数都是奇数）， 再加上 -1， nums.length-1
        int[] odds = new int[nums.length+2];
        int j = 0;
        odds[j++] = -1;
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] % 2 != 0){
                odds[j++] = i;
            }
        }
        odds[j] = nums.length;
        int res = 0;
        for(int n = 1; n < j - k + 1 ; n++){
            res += (odds[n] - odds[n-1]) * (odds[n+k] - odds[n+k-1]);
        }
        return res;
    }
}
