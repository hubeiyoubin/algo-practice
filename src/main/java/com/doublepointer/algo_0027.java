package com.doublepointer;

/**
 * @author yb
 * @date: 2021-1-27
 * 27 移除元素
 */
public class algo_0027 {
    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0)
            return 0;
        int start = 0, end = 0;
        while(end < nums.length){
            if(nums[end] != val){
                nums[start] = nums[end];
                start++;
            }
            end ++;
        }
        return start;
    }
}
