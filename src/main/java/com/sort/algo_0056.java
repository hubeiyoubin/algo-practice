package com.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author yb
 * @date: 2021-2-18
 * 56 合并区间
 */
public class algo_0056 {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length <= 1)
            return intervals;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < intervals.length; i ++){
            int[] temp = intervals[i];
            if(list.size() == 0 || list.get(list.size() - 1)[1] < temp[0]){
                list.add(temp);
            } else {
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1] , temp[1]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
