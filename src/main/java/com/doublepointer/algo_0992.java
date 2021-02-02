package com.doublepointer;

import java.util.HashMap;

/**
 * @author yb
 * @date: 2021-2-2
 * 992 K 个不同整数的子数组
 */
public class algo_0992 {

    public int subarraysWithKDistinct(int[] A, int K) {
        if(A == null || A.length == 0)
            return 0;
        int i = 0, j = 0;
        Window w1 = new Window();
        Window w2 = new Window();
        int res = 0;
        for(int r = 0; r < A.length; r ++){
            w1.add(A[r]);
            w2.add(A[r]);
            while(w1.getDifferent() > K){
                w1.remove(A[i]);
                i++;
            }
            while(w2.getDifferent() >=K){
                w2.remove(A[j]);
                j++;
            }
            res += j - i;
        }
        return res;
    }

    class Window{
        private int different;
        private HashMap<Integer, Integer> map;
        public Window(){
            different = 0;
            map = new HashMap<>();
        }
        public void add(int num){
            map.put(num, map.getOrDefault(num, 0) + 1);
            if(map.getOrDefault(num, 0) == 1){
                different++;
            }
        }
        public void remove(int num){
            map.put(num, map.getOrDefault(num, 0) - 1);
            if(map.getOrDefault(num, 0) == 0){
                different--;
            }
        }
        public int getDifferent() {
            return different;
        }
    }
}
