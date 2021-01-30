package com.doublepointer;

import java.util.Arrays;

/**
 * @author : youbin
 * @date : 2021/1/30 22:58
 * 532 数组中的 k-diff 数对
 */
public class algo_0532 {

    public int findPairs(int[] nums, int k) {
        if(nums == null || nums.length < 2)
            return 0;
        Arrays.sort(nums);
        int count = 0;
        int start = 0;
        while(start < nums.length - 1) {
            if (start > 0 && nums[start] == nums[start - 1]) {
                start++;
                continue;
            }
            int end = start + 1;
            while (end < nums.length) {
                int n = nums[end] - nums[start];
//                System.out.println("i:"+nums[start]);
//                System.out.println("e:"+nums[end]);
                if (n == k) {
                    count++;
                    break;
                } else if (n > k) {
                    break;
                }
                end ++;
            }
            start ++;
        }
        return count;
    }
}

