package com.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author yb
 * @date: 2021-2-22
 * 973 最接近原点的 K 个点
 */
public class algo_0973 {


    /**
     *  堆
     * @param points
     * @param K
     * @return
     */
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        for(int i = 0; i < K; i ++){
            pq.offer(new int[]{points[i][0]*points[i][0] + points[i][1]*points[i][1], i});
        }
        for(int i = K; i < points.length; i ++){
            int temp = pq.peek()[0];
            int dist = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            if(dist < temp){
                pq.poll();
                pq.offer(new int[]{dist, i});
            }
        }
        int[][] res = new int[K][2];
        for(int i = 0; i < K; i++){
            res[i] = points[pq.poll()[1]];
        }
        return res;
    }
    /**
     * 排序，取前k个值
     * @param points
     * @param K
     * @return
     */
    public int[][] kClosest_(int[][] points, int K) {
        Arrays.sort(points, (a, b) -> a[0]*a[0] + a[1]*a[1] - b[0]*b[0] - b[1]*b[1] );
        return Arrays.copyOfRange(points, 0, K);
    }
}
