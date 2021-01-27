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


    public int strStr_(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();
        if (n == 0) return 0;
        for (int i = 0; i <= m - n; i++) {
            for (int j = 0; j < n; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) break;
                if (j == n - 1) return i;
            }
        }
        return -1;
    }
}
