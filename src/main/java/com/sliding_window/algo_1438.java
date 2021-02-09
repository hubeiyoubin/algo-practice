package com.sliding_window;

import java.util.TreeMap;

/**
 * @author yb
 * @date: 2021-2-9
 * 1438 绝对差不超过限制的最长连续子数组
 */
public class algo_1438 {

    public int longestSubarray(int[] nums, int limit) {
        // 滑动窗口，每移动一次更新最大值和最小值
        // 问题转换就是如何求滑动窗口最大和最小值
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int left = 0, right = 0, len = 0;
        while(right < nums.length){
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            right++;
            while(map.lastKey() - map.firstKey() > limit){
                map.put(nums[left], map.getOrDefault(nums[left], 0) - 1);
                if(map.getOrDefault(nums[left], 0) == 0)
                    map.remove(nums[left]);
                left ++;
            }
            len = Math.max(len, right - left);
        }
        return len;
    }
}
