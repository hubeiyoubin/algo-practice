package com.sort;

import java.util.Arrays;

/**
 * @author yb
 * @date: 2021-2-19
 * 976 三角形的最大周长
 */
public class algo_0976 {
    public int largestPerimeter(int[] A) {
        if(A == null || A.length < 3)
            return 0;
        int len = 0;
        Arrays.sort(A);
        for(int i = A.length - 1; i >= 2; i --){
            if(A[i] - A[i-1] < A[i - 2]){
                len = A[i] + A[i-1] + A[i-2];
                return len;
            }
        }
        return len;
    }
}
