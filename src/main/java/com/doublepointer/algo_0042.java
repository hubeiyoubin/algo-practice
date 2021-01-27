package com.doublepointer;

/**
 * @author yb
 * @date: 2021-1-27
 * 42 接雨水
 */
public class algo_0042 {
    public int trap(int[] height) {
        if(height == null || height.length == 0)
            return 0;
        int left = 0, right = height.length - 1;
        int max_left = 0, max_right = 0, res = 0;
        while(left < right){
            if(height[left] < height[right]){
                if(height[left] > max_left){
                    max_left = height[left];
                } else {
                    res = res + (max_left - height[left]);
                }
                left ++;
            } else {
                if(height[right] > max_right){
                    max_right = height[right];
                } else {
                    res = res + (max_right - height[right]);
                }
                right --;
            }
        }
        return res;
    }
}
