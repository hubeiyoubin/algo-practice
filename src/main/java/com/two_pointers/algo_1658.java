package com.two_pointers;

/**
 * @author yb
 * @date: 2021-2-3
 */
public class algo_1658 {
    //[3,0,1,8,3,2,2], x = 4
    //思路转换成寻找连续区间和为sum-x的最大值，就简单了
    public int minOperations(int[] nums, int x) {
        if(nums == null || nums.length == 0)
            return 0;
        int sum = 0;
        for(int n:nums)
            sum += n;

        sum = sum - x;
        if(sum < 0)
            return -1;
        if(sum == 0)
            return nums.length;

        int left = 0, right = 0, len = -1, value = 0;
        while(right < nums.length){
            value += nums[right];
            right ++;
            //System.out.println(right);
            while(left < right && value >= sum){
                if(value == sum && right - left > len){
                    len = right - left;
                }
                value -= nums[left];
                left ++;
            }
        }
        return len == -1 ? -1 : nums.length - len;
    }
}
