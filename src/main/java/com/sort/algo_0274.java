package com.sort;

import java.util.Arrays;

/**
 * @author yb
 * @date: 2021-2-18
 * 274 H 指数
 */
public class algo_0274 {

    // 计数排序
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] papers = new int[n + 1];
        // 计数
        for (int c: citations)
            papers[Math.min(n, c)]++;
        // 找出最大的 k
        int k = n;
        int s = papers[n];
        while(k > s){
            k--;
            s += papers[k];
        }
//        for (int s = papers[n]; k > s; s += papers[k])
//            k--;
        return k;
    }


    public int hIndex_(int[] citations) {
        Arrays.sort(citations);
        int i = 0;
        while(i < citations.length && citations[citations.length - 1 -i] > i)
            i++;
        return i;
    }
}
