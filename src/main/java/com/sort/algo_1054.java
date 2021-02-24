package com.sort;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author yb
 * @date: 2021-2-24
 * 1054 距离相等的条形码
 */
public class algo_1054 {

    /**
     *  优先队列，记录 条形码的个数，按个数从大到小排序
     * @param barcodes
     * @return
     */
    public int[] rearrangeBarcodes(int[] barcodes) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int code: barcodes){
            map.put(code, map.getOrDefault(code, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for(int key : map.keySet()){
            pq.offer(key);
        }
        int[] res = new int[barcodes.length];
        int index = 0;
        //System.out.println("--"+pq.size());
        while(pq.size() > 1){
            int a = pq.poll();
            int b = pq.poll();
            res[index++] = a;
            res[index++] = b;
            if(map.getOrDefault(a, 0) > 1){
                map.put(a, map.get(a) - 1);
                pq.offer(a);
            }
            if(map.getOrDefault(b, 0) > 1){
                map.put(b, map.get(b) - 1);
                pq.offer(b);
            }
        }
        //收尾
        //System.out.println(index);
        if(pq.size() > 0)
            res[index] = pq.poll();
        return res;
    }
}
