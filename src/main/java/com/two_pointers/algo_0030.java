package com.two_pointers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author yb
 * @date: 2021-1-27
 * 30 串联所有单词的子串
 */
public class algo_0030 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        if(s == null || s.length() == 0 || words == null || words.length == 0)
            return list;
        int sLen = s.length();
        int words_num = words.length;
        int wLen = words[0].length();
        HashMap<String,Integer> map = new HashMap<>();
        for(String str: words){
            map.put(str, map.getOrDefault(str,0) + 1);
        }
        for(int i=0; i<wLen; i++){
            int left = i, right = i,count = 0;
            HashMap<String, Integer> tmp_map = new HashMap<>();
            while(right <= sLen - wLen ){
                //System.out.println("---"+right );
                //System.out.println(right + wLen);
                String str = s.substring(right, right+wLen);
                //System.out.println("---"+str);
                right = right + wLen;
                if(!map.containsKey(str)){
                    count = 0;
                    tmp_map.clear();
                    left = right;
                } else {
                    tmp_map.put(str, tmp_map.getOrDefault(str, 0) + 1);
                    count++;
                    while(tmp_map.getOrDefault(str, 0) > map.getOrDefault(str, 0)){
                        //System.out.println("left : "+ left);
                        String t_w = s.substring(left, left + wLen);
                        //System.out.println("t_w : " + t_w);
                        count--;
                        tmp_map.put(t_w, tmp_map.getOrDefault(t_w, 0) - 1);
                        left += wLen;
                    }
                    if(count == words_num)
                        list.add(left);
                }
            }
        }
        return list;
    }
}
