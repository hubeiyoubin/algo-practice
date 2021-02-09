package com.sliding_window;

/**
 * @author yb
 * @date: 2021-2-9
 * 1208 尽可能使字符串相等
 */
public class algo_1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        // 计算出两个字符串 每个字符的开销，然后用滑动窗口找出最大的开销值的连续长度
        int[] diff = new int[s.length()];
        for(int i = 0; i< s.length(); i++){
            diff[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int left = 0, right = 0, len = 0;
        int cost = 0;
        while(right < diff.length){
            cost += diff[right];
            right ++;
            while(cost > maxCost){
                cost -= diff[left];
                left ++;
            }
            len = Math.max(right - left, len);
        }
        return len;
    }
}
