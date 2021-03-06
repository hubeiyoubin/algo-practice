package com.sliding_window;

import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;

/**
 * @author yb
 * @date: 2021-2-9
 * 1438 绝对差不超过限制的最长连续子数组
 */
public class algo_1438 {

    // 用单调队列维护当前窗口的最大值和最小值，保持最大值与最小值的差小于 limit 即可
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> min = new LinkedList<>();
        Deque<Integer> max = new LinkedList<>();
        int len = 0;
        int left = 0, right = 0;
        while (right < nums.length){
            while(!max.isEmpty() && nums[max.peekLast()] < nums[right]){
                max.pollLast();
            }
            max.offer(right);

            while (!min.isEmpty() && nums[min.peekLast()] > nums[right]){
                min.pollLast();
            }
            min.offer(right);
            while(!max.isEmpty() && !min.isEmpty()
                    && nums[max.peek()] - nums[min.peek()] > limit ){
                //System.out.println("--:"+nums[max.peek()]);
                if(min.peek() <= left)
                    min.poll();
                if(max.peek() <= left)
                    max.poll();
                left ++;
            }
            len = Math.max(len, right - left + 1);
            right ++;
        }
        return len;
    }

    /**
     *  使用treeMap来维护最大最小值
     * @param nums
     * @param limit
     * @return
     */
    public int longestSubarray_(int[] nums, int limit) {
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
