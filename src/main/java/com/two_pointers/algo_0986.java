package com.two_pointers;

import java.util.ArrayList;

/**
 * @author yb
 * @date: 2021-2-2
 * 986 区间列表的交集
 */
public class algo_0986 {
    /**
     *  双指针
     * @param firstList
     * @param secondList
     * @return
     */
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        ArrayList<int[]> list = new ArrayList<>();
        if(firstList == null || secondList == null ||
                firstList.length == 0 || secondList.length == 0)
            return list.toArray(new int[][]{});
        int f = 0, s = 0;
        while(f < firstList.length && s < secondList.length){
            int start = Math.max(firstList[f][0], secondList[s][0]);
            int end = Math.min(firstList[f][1], secondList[s][1]);
            if(start <= end){
                list.add(new int[]{start, end});
            }
            if(firstList[f][1] > secondList[s][1]){
                s ++;
            } else {
                f ++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
