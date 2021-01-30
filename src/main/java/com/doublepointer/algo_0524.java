package com.doublepointer;

import java.util.List;

/**
 * @author : youbin
 * @date : 2021/1/30 20:52
 * 524 通过删除字母匹配到字典里最长单词
 */
public class algo_0524 {

    public String findLongestWord_(String s, List<String> d) {
        if(s == null || s.length() == 0 || d == null || d.size() == 0)
            return "";
        String longest = "";
        for(String str : d){
            if(isLongest(s, str, longest.length())) {
                if (longest.length() == 0 || str.length() > longest.length() || (str.length() == longest.length() && str.compareTo(longest) < 0)) {
                    longest = str;
                }
            }
        }
        return longest;
    }
    //abpcplea apple
    private boolean isLongest(String s, String str, int max){
        if(s.length() < str.length() || str.length() < max)
            return false;
        int i = 0, j = 0;
        while(i < s.length() && j < str.length()){
            if(s.charAt(i) == str.charAt(j)){
                i ++;
                j ++;
            } else if(s.charAt(i) != str.charAt(j)){
                i++;
            }
        }
        return j == str.length();
    }


    int max;
    String longest;
    public String findLongestWord(String s, List<String> d) {
        if(s == null || s.length() == 0 || d == null || d.size() == 0)
            return "";
        max = 0;
        longest = "";
        for(String str : d){
            isLongest(s, str);
        }
        return longest;
    }
    //abpcplea apple
    private void isLongest(String s, String str){
        if(s.length() < str.length() || max > str.length())
            return;
        int i = 0, j = 0;
        while(i < s.length() && j < str.length()){
//                System.out.println("i:"+i);
//                System.out.println("j:"+j);
            if(s.charAt(i) == str.charAt(j)){
                i ++;
                j ++;
            } else if(s.charAt(i) != str.charAt(j)){
                i++;
            }
        }
        //System.out.println("max:" + max);
        if(j >= max && j == str.length()){
            if(longest.length() == 0 || str.length() > max || (str.length() == longest.length() && str.compareTo(longest) < 0)){
                max = j;
                longest = str;
            }
        }
    }
}
