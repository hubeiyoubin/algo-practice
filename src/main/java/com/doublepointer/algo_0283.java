package com.doublepointer;

/**
 * @author : youbin
 * @date : 2021/1/28 23:15
 * 283 移动零
 */
public class algo_0283 {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length < 2)
            return;
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }

    }

    private void swap(int[] nums, int left, int right){
        if(left == right)
            return;
        int temp = nums[right];
        nums[right] = nums[left];
        nums[left] = temp;
    }
}
