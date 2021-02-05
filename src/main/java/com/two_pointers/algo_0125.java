package com.two_pointers;

/**
 * @author yb
 * @date: 2021-1-28
 * 125 验证回文串
 */
public class algo_0125 {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0)
            return true;
        int left = 0, right = s.length() -1;
        while(left < right){
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if(Character.toLowerCase(s.charAt(left)) !=Character.toLowerCase(s.charAt(right)))
                return false;

            left ++;
            right --;
        }
        return true;
    }
}
