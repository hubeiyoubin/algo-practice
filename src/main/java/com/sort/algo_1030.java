package com.sort;

import java.util.Arrays;

/**
 * @author yb
 * @date: 2021-2-23
 * 1030 距离顺序排列矩阵单元格
 */
public class algo_1030 {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] res = new int[R * C][2];
        int rs = r0, re = r0;
        int cs = c0, ce = c0;

        int k = 0;
        for(int i = 0; i < R; i ++){
            for(int j = 0; j < C; j ++){
                res[k] = new int[]{i, j};
                k ++;
            }
        }
        Arrays.sort(res, (o1, o2) -> Math.abs(o1[0] - r0) + Math.abs(o1[1]- c0)- Math.abs(o2[0] - r0) - Math.abs(o2[1]- c0));
        return res;
    }
}
