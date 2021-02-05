package com.two_pointers;

/**
 * @author yb
 * @date: 2021-1-29
 * 344 反转字符串
 */
public class algo_0344 {
    public void reverseString(char[] s) {
        if(s == null || s.length < 2)
            return;
        int left = 0, right = s.length - 1;
        while(left < right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left ++;
            right --;
        }
    }
}
