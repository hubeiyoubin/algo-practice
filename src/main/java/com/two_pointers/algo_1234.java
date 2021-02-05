package com.two_pointers;

import java.util.HashMap;

/**
 * @author : youbin
 * @date : 2021/2/2 23:11
 * 1234 替换子串得到平衡字符串
 */
public class algo_1234 {

    /**
     *  找出多余的字符及其个数，然后用滑动窗口找出包含这些字符的最短子字符串
     * @param s
     * @return
     */
    public int balancedString(String s) {
        if(s == null || s.length() == 0)
            return 0;
        int left = 0, right = s.length()-1;
        int q = s.length()/ 4, w = s.length()/ 4,e = s.length()/ 4,r = s.length()/ 4;
        while(left <= right){
            char c = s.charAt(left);
            if(c == 'Q')
                q--;
            if(c == 'W')
                w--;
            if(c == 'E')
                e--;
            if(c == 'R')
                r--;
            left ++;
        }

        HashMap<Character,Integer> map = new HashMap<>();
        if(q < 0)
            map.put('Q',-q);
        if(w < 0)
            map.put('W',-w);
        if(e < 0)
            map.put('E',-e);
        if(r < 0)
            map.put('R',-r);

        if(map.size() == 0)
            return 0;

        int i = 0, j = 0, len = Integer.MAX_VALUE, valid = 0;
        HashMap<Character,Integer> temp = new HashMap<>();
        while(j < s.length()){
            char c = s.charAt(j);
            j ++;
            if(map.getOrDefault(c, 0) > 0){
                temp.put(c, temp.getOrDefault(c, 0) + 1);
                if(temp.getOrDefault(c, 0).equals(map.getOrDefault(c, 0))){
                    valid ++;
                }
            }
            while(valid == map.size()){
//                System.out.println(j);
//                System.out.println("--:"+i);
                if(j - i < len){
                    len = j - i;
                }
                char d = s.charAt(i);
                i ++;
                if(map.getOrDefault(d, 0) > 0){
                    temp.put(d, temp.getOrDefault(d, 0) - 1);
                    if(temp.getOrDefault(d, 0) < map.getOrDefault(d, 0) ){
                        valid --;
                    }
                }
            }

        }
        return len;
    }
}
