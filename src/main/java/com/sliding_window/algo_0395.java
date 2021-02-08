package com.sliding_window;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yb
 * @date: 2021-2-8
 * 395 至少有K个重复字符的最长子串
 */
public class algo_0395 {

    public int longestSubstring_(String s, int k) {
        int res = 0;
        // 试探input字符串中是否能找到一个最长的字符串，存在有numUniqueTarget个不同字符
        // 我们这里是从1 - 26一个个去试探
        for (int numUniqueTarget = 1; numUniqueTarget <= 26; numUniqueTarget++) {
            res = Math.max(res, helper(s, k, numUniqueTarget));
        }
        return res;
    }

    // sliding window模板
    private int helper(String s, int k, int i) {
        int[] map = new int[256];
        int start = 0;
        int end = 0;
        int res = Integer.MIN_VALUE;
        // 子串内unique的字母个数
        int counter = 0;
        // 出现次数不少于K的字母个数
        int numNoLessThanK = 0;
        while (end < s.length()) {
            char c1 = s.charAt(end);
            if (map[c1]++ == 0) {
                counter++;
            }
            if (map[c1] == k) {
                numNoLessThanK++;
            }
            end++;

            while (counter > i) {
                char c2 = s.charAt(start);
                if (map[c2]-- == k) {
                    numNoLessThanK--;
                }
                if (map[c2] == 0) {
                    counter--;
                }
                start++;
            }

            if (counter == numNoLessThanK) {
                res = Math.max(res, end - start);
            }
        }
        return res;
    }


    // 递归
    public int longestSubstring_1(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char chs : s.toCharArray()) {
            map.put(chs, map.getOrDefault(chs, 0) + 1);
        }

        // 这里是先把 s 传进 sb 中来找出不满足 k 个的元素及其位置
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) < k) {
                sb.setCharAt(i, ',');
            }
        }

        // 然后以不符合要求的元素位置进行分割存储到字符串数组中
        String[] string = sb.toString().split(",");
        // 如果仅有一组，则说明只有一个字母，返回首字母既可
        if (string.length == 1) {
            return string[0].length();
        }
        int max = 0;
        // 如果有多组，就进行最大值比较
        // 例如 aaabcccc，通过上面的操作后 化为 aaa,cccc
        for (String str : string) {
            max = Math.max(max, longestSubstring_1(str, k));
        }
        return max;
    }
}
