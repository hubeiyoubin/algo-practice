package com.sort;

import java.util.Arrays;

/**
 * @author yb
 * @date: 2021-2-18
 * 242 有效的字母异位词
 */
public class algo_0242 {
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null || s.length() != t.length())
            return false;
        char[] as = s.toCharArray();
        char[] at = t.toCharArray();
        Arrays.sort(as);
        Arrays.sort(at);
        for(int i = 0; i < as.length; i ++){
            if(as[i] != at[i])
                return false;
        }
        return true;

        // return Arrays.equals(as, at);
    }
}
