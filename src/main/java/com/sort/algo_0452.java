package com.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author yb
 * @date: 2021-2-19
 * 452 用最少数量的箭引爆气球
 */
public class algo_0452 {

    /**
     *  求交集
     * @param points
     * @return
     */
    public int findMinArrowShots(int[][] points) {
        if(points == null || points.length == 0)
            return 0;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] > o2[0]){
                    return 1;
                } else if(o1[0] < o2[0]){
                    return -1;
                } else
                    return 0;
            }
        });
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < points.length; i ++){
            int[] temp = points[i];
            //System.out.println(temp[0] + "," +temp[1]);
            if(list.size() == 0 || list.get(list.size() - 1)[1] < temp[0]){
                list.add(temp);
            } else {
                list.get(list.size() - 1)[0] = Math.max(list.get(list.size() - 1)[0], temp[0]);
                list.get(list.size() - 1)[1] = Math.min(list.get(list.size() - 1)[1], temp[1]);
            }
        }
        return list.size();
    }
}
