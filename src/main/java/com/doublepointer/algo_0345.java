package com.doublepointer;

import java.util.HashSet;

/**
 * @author yb
 * @date: 2021-1-29
 * 345 反转字符串中的元音字母
 */
public class algo_0345 {
    public String reverseVowels(String s) {
        if(s == null || s.length() < 2)
            return s;
        char[] array = s.toCharArray();
        int left = 0, right = array.length -1;
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        while(left < right){
            while(left < right && !set.contains(Character.toLowerCase(array[left])))
                left++;


            while(left < right && !set.contains(Character.toLowerCase(array[right])))
                right--;

            char temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left ++;
            right --;
        }
        return String.valueOf(array);
    }
}
