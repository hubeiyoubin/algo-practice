package com.algo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @date : 2019-10-29
 */
public class algo_0001 {


/*    给定 nums = [2, 7, 11, 15], target = 9
    因为 nums[0] + nums[1] = 2 + 7 = 9
    所以返回 [0, 1]*/

    private static int[] twoSum(int[] nums, int target) {
        int[] two = new int[]{-1,-1};
        if(nums == null || nums.length < 1){
            return two;
        }
        Map<Integer,Integer> map =new HashMap();
        for(int i= 0;i<nums.length;i++){
            int other = target - nums[i];
            if(map.containsKey(other)){
                two[1] = i;
                two[0] = map.get(other);
                break;
            }else{
                map.put(nums[i],i);
            }
        }

        return two;
    }

    private static int[] twoSum2(int[] nums, int target) {
        int[] two = new int[2];
        if(nums == null || nums.length < 2){
            return two;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i ++){
            int a = target - nums[i];
            if(map.containsKey(a)){
                two[1] = i;
                two[0] = map.get(a);
                break;
            }else{
                map.put(nums[i],i);
            }
        }
        return two;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15 , 3 ,4,5 ,6};
        int target = 10;
        long start = System.currentTimeMillis();
        System.out.println(Arrays.toString(twoSum2(nums,target)));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
