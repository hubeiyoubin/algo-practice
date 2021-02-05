package com.two_pointers;

/**
 * @author : youbin
 * @date : 2021/1/31 18:03
 * 713 乘积小于K的子数组
 */
public class algo_0713 {


    /**
     *  双指针解法
     * @param nums
     * @param k
     * @return
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k <= 1)
            return 0;
        int count = 0;
        int x = 1, left = 0;
        for(int i =0; i<nums.length; i++){
            x = x * nums[i];
            while(x >= k){
                x = x / nums[left];
                left ++;
            }
            count = count + i - left + 1;
        }
        return count;
    }

    /**
     *  暴力求解， Time Limit Exceeded
     * @param nums
     * @param k
     * @return
     */
    public int numSubarrayProductLessThanK_(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k <= 1)
            return 0;
        int count = 0;
        for(int i =0; i<nums.length; i++){
            int x = nums[i];
            if(x < k){
//                System.out.println("i--:" + i );
//                System.out.println("x--:" + x );
                count ++;
            } else {
                continue;
            }
            for(int j=i+1; j<nums.length;j++){
                x = x * nums[j];
                if(x < k){
//                    System.out.println("x:" + x );
                    count ++;
                } else {
                    break;
                }
            }
        }
        return count;
    }
}
