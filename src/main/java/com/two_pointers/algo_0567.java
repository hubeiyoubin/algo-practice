package com.two_pointers;

import java.util.HashMap;

/**
 * @author : youbin
 * @date : 2021/1/31 0:38
 * 567 字符串的排列
 */
public class algo_0567 {
    public boolean checkInclusion(String s1, String s2) {
        if(s1 == null || s2 == null || s1.length() > s2.length())
            return false;

        HashMap<Character, Integer> map = new HashMap<>();
        for(Character c : s1.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        HashMap<Character, Integer> temp = new HashMap<>();
        int left = 0, right = 0;
        int valid = 0;
        while(right < s2.length()){
            char c = s2.charAt(right);
            right ++;

            if(map.containsKey(c)){
//                System.out.println("left:"+left);
//                System.out.println("right:"+right);
                temp.put(c, temp.getOrDefault(c, 0) + 1);
                if(temp.getOrDefault(c,0).equals(map.getOrDefault(c, 0))){
                    valid ++;
                }
            }
            int len = right - left;
            while(len >= s1.length()) {
                if(valid == map.size()) {
                    return true;
                }
                char d = s2.charAt(left);
                left ++;
                len = right - left;
                if(map.containsKey(d)){
                    if(temp.getOrDefault(d,0).equals(map.getOrDefault(d, 0))){
                        valid --;
                    }
                    temp.put(d, temp.getOrDefault(d, 0) - 1);
                }
            }


        }
        return false;
    }
}
