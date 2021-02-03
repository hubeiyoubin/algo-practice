package com.doublepointer;

import java.util.HashSet;

/**
 * @author : youbin
 * @date : 2021/2/3 23:00
 * 1695 删除子数组的最大得分
 */
public class algo_1695 {
    public int maximumUniqueSubarray(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        HashSet<Integer> set = new HashSet<>();
        int left = 0, right = 0;
        int max = 0, sum = 0;
        while(right < nums.length){
            if(!set.contains(nums[right])){
                set.add(nums[right]);
                //System.out.println("right--:"+nums[right]);
                sum += nums[right];
                max = Math.max(sum, max);
                right ++;
            } else {
                //System.out.println("left--:"+nums[left]);
                set.remove(nums[left]);
                sum -= nums[left];
                left ++;
            }
        }
        return max;
    }
}
