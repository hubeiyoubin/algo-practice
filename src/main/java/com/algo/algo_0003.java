package com.algo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @date : 2019-11-7
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

 */
public class algo_0003 {

    public static int getNoReString(String s){
        int left = 0;
        int right = 0;
        int max = 0;
        boolean[] isHave = new boolean[128];
        for(right = 0; right < s.length(); right ++){
            char c = s.charAt(right);
            if(!isHave[c]){
                isHave[c] = true;
            }else{
                max = Math.max(max,right - left);
                System.out.println("sub--"+s.substring(left,right));
                for(int i = left ;i < right; i ++){
                    char b = s.charAt(i);
                    if(b == c){
                        left = i + 1;
                        break;
                    }else{
                        isHave[b] = false;
                    }
                }

            }
        }
        max = Math.max(max,right - left);
        System.out.println("sub--"+s.substring(left,right));
        return max;
    }

    // abcabcbb
    public static int lengthOfLongestSubstring_b(String s){
        int max = 0;
        int[] index = new int[128];
        for(int i = 0, j = 0; j < s.length(); j ++){
            char c = s.charAt(j);
            i = Math.max(index[c], i);
            max = Math.max(max, j - i + 1 );
            System.out.println("s--" + s.substring(i,j + 1));
            index[c] = j + 1;
        }
        return max;
    }


    public int lengthOfLongestSubstring_a(String s) {
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int end = 0, start = 0; end < s.length(); end ++){
            char c = s.charAt(end);
            if (map.containsKey(c))
                start = Math.max(map.get(c), start);
            max = Math.max(max , end - start + 1);
            map.put(c, end + 1);
        }
        return max;
    }

    public int lengthOfLongestSubstring_02(String s){
        int max = 0;
        int start = 0;
        Map<Character,Integer> map = new HashMap<>();
        for(int end = 0; end < s.length(); end ++){
            char c = s.charAt(end);
            if(map.containsKey(c))
                start = Math.max(start ,map.get(c));
            map.put(c,end +1);
            max = Math.max(max , end -start + 1);
        }
        return max;
    }


    public int lengthOfLongestSubstring03(String s) {
        int i = 0;
        int flag = 0;
        int length = 0;
        int result = 0;
        while (i < s.length()) {
            int pos = s.indexOf(s.charAt(i),flag);
            if (pos < i) {
                if (length > result) {
                    result = length;
                }
                if (result >= s.length() - pos - 1) {
                    return result;
                }
                length = i - pos - 1;
                flag = pos + 1;
            }
            length++;
            i++;
        }
        return length;
    }

    public static int lengthOfLongestSubstring_04(String s){
       int max = 0;
       StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i ++){
           int index = sb.indexOf(Character.toString(s.charAt(i))) + 1;
           if(index > 0){
               sb = sb.delete(0 , index);
           }
           sb.append(s.charAt(i));
           max = max > sb.length() ? max : sb.length();
       }
       return max;
    }





    public int lengthOfLongestSubstring04(String s) {
        int max = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (sb.indexOf(Character.toString(s.charAt(i))) != -1) {
                int index = sb.indexOf(Character.toString(s.charAt(i))) + 1;
                sb = sb.delete(0, index);
            }
            sb.append(s.charAt(i));
            if (sb.length() > max) {
                max = sb.length();
            }
        }
        return max;
    }

    public static int lengthOfLongestSubstring_05(String s) {
        Set<Character> set = new HashSet<>();
        int start = 0;
        int end = 0 , max = 0;
        while(end < s.length()){
            char c = s.charAt(end);
            if(!set.contains(c)){
                set.add(c);
                end ++;
                max = Math.max(max,set.size());
            }else{
                set.remove(s.charAt(start));
                start ++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
       // System.out.println(getNoReString("abcabcbb"));
        System.out.println(lengthOfLongestSubstring_04("abcabcbb"));
    }
}
