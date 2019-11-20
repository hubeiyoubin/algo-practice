package com.algo;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @date : 2019-11-20
 *
 * 18. 四数之和
 *
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 */
public class algo_0018 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums == null || nums.length < 4)
            return list;

        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; i ++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i + 1; j < nums.length - 2; j ++){
                if( j > i + 1 && nums[j] == nums[j-1]) continue;
                int start = j + 1;
                int end = nums.length - 1;
                while(start < end){
                    int sum = nums[i] + nums[j] + nums[start] + nums[end];
                    System.out.println("i="+i+",j="+j+",start="+start+",end="+end);
                    System.out.println(nums[i] +","+ nums[j] +","+ nums[start] +","+ nums[end]);
                    System.out.println("sum=" + sum);
                    if(sum == target){
                        list.add(Arrays.asList(nums[i] ,nums[j] ,nums[start] ,nums[end]));
                        while(start < end && nums[start] == nums[start+1]) start ++;
                        while(start < end && nums[end] == nums[end-1]) end --;
                        start ++;
                        end --;
                    }else if(sum < target){
                        start ++;
                    }else{
                        end --;
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,0,0,0,1};
        System.out.println(JSONObject.toJSONString(new algo_0018().fourSum(nums,0)));
    }
}
