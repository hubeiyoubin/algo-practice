package com.algo;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author yb
 * @date: 2020-11-4
 */
public class algo_0527 {
    public static void main(String[] args) {
        String  s = "abpcplea";
        List<String> d = Arrays.asList("apple","ale","monkey","plea");
        String result = new algo_0527().findLongestWord(s, d);
        System.out.println(result);
    }

    public String findLongestWord(String s, List<String> d) {
        String longestWord = "";
        for (String target : d) {
            int l1 = longestWord.length(), l2 = target.length();
            if (l1 > l2 || (l1 == l2 && longestWord.compareTo(target) < 0)) {
                continue;
            }
            if (isSubstr(s, target)) {
                longestWord = target;
            }
        }
        return longestWord;
    }

    private boolean isSubstr(String s, String target) {
        int i = 0, j = 0;
        //abpcplea apple
        while (i < s.length() && j < target.length()) {
            if (s.charAt(i) == target.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == target.length();
    }

    @Test
    public void testString(){
        String a = "apple";
        String b = "abpcp";
        System.out.println(a.compareTo(b));
    }
}
