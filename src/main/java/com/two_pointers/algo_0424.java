package com.two_pointers;

/**
 * @author yb
 * @date: 2021-1-29
 * 424 替换后的最长重复字符
 */
public class algo_0424 {
    public int characterReplacement(String s, int k) {
        if(s == null || s.length() == 0)
            return 0;
        int left = 0, right = 0;
        int count = 0, len = 0;
        int[] alpha = new int[26];
        while(right < s.length()){
            char c = s.charAt(right);
            alpha[c-'A']++;
            count = Math.max(count, alpha[c-'A']);
            if(right - left + 1 - count > k){
                alpha[s.charAt(left)-'A']--;
                left ++;
            }
            len = Math.max(len, right-left+1);
            right ++;
        }
        return len;
    }
}
