package com.doublepointer;

/**
 * @author yb
 * @date: 2021-1-28
 * 80 删除排序数组中的重复项 II
 */
public class algo_0080 {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int slow = 1;
        int count = 1;
        for(int i=1; i<nums.length; i++){
            if(nums[i] == nums[i-1]){
                count ++;
            } else {
                count = 1;
            }
            if(count <= 2){
                nums[slow] = nums[i];
                slow ++;
            }
        }
        return slow;
    }


    public int removeDuplicates_(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int left = 1, right = 1;
        int count = 1;
        while(right < nums.length) {
            if(nums[right] == nums[right-1]){
                count ++;
            } else {
                count = 1;
            }
            if(count <= 2)
                nums[left++] = nums[right];

            right ++;
        }
        return left;
    }
}
