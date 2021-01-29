package com.doublepointer;

/**
 * @author yb
 * @date: 2021-1-29
 * 977 有序数组的平方
 */
public class algo_0977 {
    public int[] sortedSquares(int[] nums) {
        if(nums == null || nums.length == 0)
            return new int[]{};
        int left = 0, right = nums.length - 1, index = nums.length - 1;
        int[] res = new int[nums.length];
        while(index >= 0 && left <= right){
            int fs = nums[left] * nums[left];
            int rs = nums[right] * nums[right];
            if(fs > rs){
                res[index] = fs;
                left ++;
            } else {
                res[index] = rs;
                right --;
            }
            index --;
        }
        return res;
    }
}
