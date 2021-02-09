package com.sliding_window;

import java.util.HashSet;

/**
 * @author yb
 * @date: 2021-2-9
 * 1456 定长子串中元音的最大数目
 */
public class algo_1456 {
    public int maxVowels(String s, int k) {
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int left = 0, right = 0, maxCount = 0, count = 0;
        while(right < s.length()){
            char r = s.charAt(right);
            right ++;
            if(set.contains(r))
                count ++;
            while(right - left > k){
                char f = s.charAt(left);
                if(set.contains(f))
                    count --;
                left ++;
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}
