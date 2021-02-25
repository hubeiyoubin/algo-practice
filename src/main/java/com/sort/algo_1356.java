package com.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author yb
 * @date: 2021-2-24
 * 1356 根据数字二进制下 1 的数目排序
 */
public class algo_1356 {
    public int[] sortByBits(int[] arr) {
        // 将所有数的二进制 1 的数目计算出来
        int[] bit = new int[10001];
        for (int i = 1; i <= 10000; ++i) {
            bit[i] = bit[i >> 1] + (i & 1);
        }
        Integer[] arrIn = new Integer[arr.length];
        for(int i = 0; i < arr.length; i ++){
            arrIn[i] = Integer.valueOf(arr[i]);
        }
        Arrays.sort(arrIn, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return bit[o1] != bit[o2] ? bit[o1] - bit[o2] : o1 - o2;
            }
        });
        for(int i = 0; i < arr.length; i ++){
            arr[i] = arrIn[i].intValue();
        }
        return arr;
    }
}
