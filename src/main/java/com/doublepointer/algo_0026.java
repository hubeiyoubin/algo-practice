package com.doublepointer;

/**
 * @author yb
 * @date: 2021-1-27
 * 26 删除排序数组中的重复项
 */
public class algo_0026 {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int start = 0, end = 1;
        while(end < nums.length){
            if(nums[start] == nums[end]){
                end ++;
            } else {
                nums[++start] = nums[end];
            }
        }
        return start+1;
    }
}
