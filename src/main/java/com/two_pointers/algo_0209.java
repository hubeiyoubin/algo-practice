package com.two_pointers;

/**
 * @author : youbin
 * @date : 2021/1/28 21:58
 * 209 长度最小的子数组
 */
public class algo_0209 {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int left = 0, right = 0;
        int sum = 0;
        int len = Integer.MAX_VALUE;
        while(right < nums.length){
            int rv = nums[right];
            sum += rv;
            right++;
            //System.out.println("rv:"+rv);
            while(left <= right && s <= sum){
                if(right - left < len){
                    len = right - left;
//                    System.out.println("right:"+right);
//                    System.out.println("left:"+left);
//                    System.out.println("len:"+len);
                }
                int fv = nums[left];
                //System.out.println("fv:"+fv);
                sum -= fv;
                //System.out.println("sum:"+sum);
                left ++;
            }
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }
}
