package com.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yb
 * @date: 2021-2-18
 * 57 插入区间
 */
public class algo_0057 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        boolean placed = false;
        int left = newInterval[0];
        int right = newInterval[1];
        for(int i = 0; i < intervals.length; i ++){
            int[] interval = intervals[i];
            if (interval[0] > right) {
                // 在插入区间的右侧且无交集
                if (!placed) {
                    list.add(new int[]{left, right});
                    placed = true;
                }
                list.add(interval);
            } else if (interval[1] < left) {
                // 在插入区间的左侧且无交集
                list.add(interval);
            } else {
                // 与插入区间有交集，计算它们的并集
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        if(!placed){
            list.add(new int[]{left, right});
        }
        return list.toArray(new int[list.size()][]);
    }
}
