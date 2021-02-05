package com.two_pointers;

import java.util.HashMap;

/**
 * @author yb
 * @date: 2021-1-28
 * 76 最小覆盖子串
 */
public class algo_0076 {
    public String minWindow(String s, String t) {
        if(s == null || t == null)
            return null;
        int sL = s.length();
        int tL = t.length();
        if(sL == 0 || tL == 0)
            return "";
        int left=0, right=0, valid=0;
        int start=-1;
        int len = Integer.MAX_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()){
            map.put(c,map.getOrDefault(c,0) + 1);
        }
        // System.out.println("map:"+map.size());
        // System.out.println(sL);
        // System.out.println(tL);
        HashMap<Character, Integer> windowMap = new HashMap<>();
        while(right < sL){
            char r = s.charAt(right);
            right++;
            if(map.getOrDefault(r,0) != 0){
                windowMap.put(r, windowMap.getOrDefault(r, 0) + 1);
                if(windowMap.get(r).equals(map.get(r))) {
                    valid++;
                }
            }


            while(valid == map.size()){
                if(right - left < len){
                    start = left;
                    len = right - left;
                }
                //System.out.println("start:"+start);
                //System.out.println("len:"+len);
                char d = s.charAt(left);
                left++;
                if(map.getOrDefault(d,0) != 0){
                    // System.out.println("D:"+d);
                    // System.out.println("windowMap.get(d):"+windowMap.get(d));

                    if(map.get(d).equals(windowMap.get(d))){
                        valid --;
                        //   System.out.println("map.get(d):"+map.get(d));
                        //   System.out.println("valid:"+valid);
                    }
                    windowMap.put(d, windowMap.get(d) - 1);
                }
            }

        }
        return start == -1 ? "" : s.substring(start, start+len);
    }
}
