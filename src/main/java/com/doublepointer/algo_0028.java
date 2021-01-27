package com.doublepointer;

/**
 * @author yb
 * @date: 2021-1-27
 * 28 实现 strStr()
 */
public class algo_0028 {
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null)
            return -1;
        int nl = needle.length();
        int hl = haystack.length();
        if(nl == 0)
            return 0;
        if(hl == 0)
            return -1;
        int start = 0;
        while(start <= hl - nl){
            while(start <= hl-nl && haystack.charAt(start) != needle.charAt(0)){
                start ++;
            }
            int end = 0, curLen = 0;
            while(end < nl && start < hl && haystack.charAt(start) == needle.charAt(end)){
                start++;
                end++;
                curLen++;
            }
            if(curLen == nl)
                return start - nl;
            start = start - curLen + 1;
        }
        return -1;
    }
}
