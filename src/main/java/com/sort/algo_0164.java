package com.sort;

import java.util.Arrays;

/**
 * @author yb
 * @date: 2021-2-18
 * 164 最大间距
 */
public class algo_0164 {
    public int maximumGap(int[] nums) {
        if(nums == null || nums.length < 2)
            return 0;
        Arrays.sort(nums);
        int max = 0;
        for(int i = 1; i < nums.length; i ++){
            max = Math.max(nums[i] - nums[i-1], max);
        }
        return max;
    }
}
