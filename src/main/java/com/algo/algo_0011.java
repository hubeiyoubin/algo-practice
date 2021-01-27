package com.algo;

/**
 * @date : 2019-11-13
 * 11. 盛最多水的容器
 *
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。

示例:

输入: [1,8,6,2,5,4,8,3,7]
输出: 49

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/container-with-most-water
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class algo_0011 {

    public static int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int maxArea = 0;
        while (start < end){
            int high = Math.min(height[start], height[end]);
            maxArea = Math.max(maxArea, high * (end - start));
            //System.out.println("high="+high +",maxArea="+maxArea);
            if(height[start] < height[end]){
                start ++;
            }else if(height[start] > height[end]){
                end --;
            }else if(height[start] == height[end]){
                start ++;
                end --;
            }
        }
        return maxArea;
    }
    //暴力求解法
    public static int maxArea_02(int[] height) {
        int maxArea = 0;
        for(int i = 0; i < height.length - 1; i ++){
            for(int j = i + 1; j < height.length; j++){
                int high = Math.min(height[i], height[j]);
                maxArea = Math.max(maxArea, high * (j - i));
                System.out.println("high="+high +",maxArea="+maxArea);
            }
        }
        return maxArea;
    }
    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea_02(height));
    }

    /**
     * 双指针解法
     * @param height
     * @return
     */
    public int maxArea_(int[] height) {
        if(height == null || height.length == 0)
            return 0;
        int left = 0, right = height.length-1, max = 0;
        while(left < right){
            int lv = height[left];
            int rv = height[right];
            int area = Math.min(lv, rv) * (right - left);
            max = Math.max(area, max);
            if(lv > rv){
                right --;
            } else {
                left ++;
            }
        }
        return max;
    }
}
