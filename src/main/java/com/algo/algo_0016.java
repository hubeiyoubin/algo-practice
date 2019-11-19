package com.algo;

import java.util.Arrays;

/**
 * @date : 2019-11-19
 *
 * 16. 最接近的三数之和
 * https://leetcode-cn.com/problems/3sum-closest
 *给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 */
public class algo_0016 {

    public static int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3){
            throw new RuntimeException("数组为空或数组整数个数不足3个");
        }
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length; i ++){
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(Math.abs(sum - target) < Math.abs(res - target)){
                    res = sum;
                }
                if(sum > target){
                    right --;
                }else if (sum < target){
                    left ++;
                }else{
                    return sum;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 2,1,-2,-1,-1, -1, 0,0,0, 1,2,2,2,2};
        System.out.println(threeSumClosest(nums, 4));
    }
}

