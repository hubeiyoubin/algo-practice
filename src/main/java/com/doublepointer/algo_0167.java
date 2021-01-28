package com.doublepointer;

/**
 * @author yb
 * @date: 2021-1-28
 * 167 两数之和 II - 输入有序数组
 */
public class algo_0167 {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers == null || numbers.length < 2)
            return new int[]{};
        int left = 0, right = numbers.length-1;
        while(left < right){
            int sum = numbers[left] + numbers[right];
            if(sum == target){
                return new int[]{left+1, right+1};
            }
            if(sum > target)
                right --;
            else
                left ++;
        }
        return new int[]{};
    }
}
