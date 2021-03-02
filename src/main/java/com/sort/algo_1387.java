package com.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @author yb
 * @date: 2021-3-2
 * 1387 将整数按权重排序
 */
public class algo_1387 {

    HashMap<Integer, Integer> map = new HashMap<>();
    public int getKth(int lo, int hi, int k) {
        List<Integer> list = new ArrayList<>();
        for(int i = lo; i <= hi; i ++){
            list.add(i);
        }
        Collections.sort(list, (o1, o2) ->{
            if(getWeight(o1) != getWeight(o2)){
                return getWeight(o1) - getWeight(o2);
            } else {
                return o1 - o2;
            }
        });
        return list.get(k - 1);
    }
    private int getWeight(int num){
        if(!map.containsKey(num)){
            if(num == 1){
                map.put(num, 0);
            } else if((num & 1) != 0){
                map.put(num, getWeight(3*num + 1) + 1);
            } else {
                map.put(num, getWeight(num / 2) + 1);
            }
        }
        return map.get(num);
    }
}
