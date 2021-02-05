package com.two_pointers;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : youbin
 * @date : 2021/2/3 23:39
 * 1711 大餐计数
 */
public class algo_1711 {
    public int countPairs(int[] deliciousness) {
        if(deliciousness == null || deliciousness.length == 0)
            return 0;
        long res = 0;
        int[] dict = new int[22];
        for(int i = 0; i < 22; i ++){
            dict[i] = (int)Math.pow(2, i);
            System.out.println(dict[i]);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int d: deliciousness){
            map.put(d, map.getOrDefault(d, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            for (int i = 0; i <= 21; i++) {
                //int sum =  1 << i;
                int sum = dict[i];
                long l = sum - key;
                if (key == l) {//如果是自己，则是从个数中组合2个数据，因为后续要除2，所以计算组合的时候不除
                    res += 1L * value * (value - 1);
                } else {
                    if (l >= 0 && map.containsKey((int) l)) {
                        res += 1L * value * map.get((int) l);
                    }
                }
            }
        }
        //结果都算了2遍
        return (int) (res / 2 % 1000000007);
    }
}
