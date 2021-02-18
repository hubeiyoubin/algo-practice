package com.sort;

import java.util.Arrays;

/**
 * @author yb
 * @date: 2021-2-18
 * 274 H 指数
 */
public class algo_0274 {

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int i = 0;
        while(i < citations.length && citations[citations.length - 1 -i] > i)
            i++;
        return i;
    }
}
