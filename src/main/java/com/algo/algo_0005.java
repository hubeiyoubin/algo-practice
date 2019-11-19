package com.algo;

/**
 * @date : 2019-11-11
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class algo_0005 {

    public String longestPalindrome(String s) {
        int length = s.length();
        boolean[][] P = new boolean[length][length];
        int maxLen = 0;
        String maxPal = "";
        for (int len = 1; len <= length; len++) //遍历所有的长度
            for (int start = 0; start < length; start++) {
                int end = start + len - 1;
                if (end >= length) //下标已经越界，结束本次循环
                    break;
                P[start][end] = (len == 1 || len == 2 || P[start + 1][end - 1]) && s.charAt(start) == s.charAt(end); //长度为 1 和 2 的单独判断下
                if (P[start][end] && len > maxLen) {
                    maxPal = s.substring(start, end + 1);
                }
            }
        return maxPal;
    }

    public static String longestPalindrome_02(String s){
       int length = s.length();
       String maxLen = "";
       int max = 0;
       boolean[][] pali = new boolean[length][length];
       for(int len = 1; len <= length; len ++){
           for(int start = 0; start < length; start ++){
               int end = start + len - 1;
               if(end > length - 1){
                   break;
               }
               pali[start][end] = (len == 1 || len ==2 || pali[start + 1][end - 1]) && s.charAt(start) == s.charAt(end);
               if(pali[start][end] && len > max){
                   maxLen = s.substring(start,end + 1);
                   max = maxLen.length();
               }
           }
       }
       return maxLen;
    }

    // 优化一
    public static String longestPalindrome_03(String s) {
        int n = s.length();
        String res = "";
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1]); //j - i 代表长度减去 1
                System.out.println("dp["+i+"]["+j+"] ="+dp[i][j] +"--" + s.substring(i, j + 1));
                if (dp[i][j] &&  j - i + 1 > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }
    //优化二
    public static String longestPalindrome_04(String s) {
        int n = s.length();
        String res = "";
        boolean[] P = new boolean[n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= i; j--) {
                P[j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || P[j - 1]);
                System.out.println("i="+i+",P["+j+"] ="+P[j] +"--" + s.substring(i, j + 1));
                if (P[j] && j - i + 1 > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

    //中心扩展法
    public static String longestPalindrome_05(String s) {
        int n = s.length();
        int left = 0;
        int right = 0;
        String maxString = "";
        for(int i = 0; i < n; i ++){
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i+1);
            int len = Math.max(len1,len2);
            System.out.println("len1:"+len1 + "  len2:"+len2);
            if(len > right - left){
                left = i - (len-1)/2;
                right = i + len/2;
                maxString = s.substring(left ,right+1);
            }
        }
        return maxString;
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int len = 0;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left --;
            right ++;
        }
        len = right - left - 1;
        return len;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome_05("aabccba"));
    }

}
