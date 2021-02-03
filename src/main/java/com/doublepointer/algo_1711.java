package com.doublepointer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : youbin
 * @date : 2021/2/3 23:39
 */
public class algo_1711 {
    public int countPairs(int[] deliciousness) {
        if (deliciousness == null || deliciousness.length == 0)
            return 0;
        long res = 0;
        int[] dict = new int[21];
        for (int i = 0; i < 21; i++) {
            dict[i] = (int) Math.pow(2, i + 1);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int d : deliciousness) {
            map.put(d, map.getOrDefault(d, 0) + 1);
        }

        for (int i = 0; i < 21; i++) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int left_num = entry.getValue();
                int right_num = map.getOrDefault(dict[i] - entry.getKey(), 0);
                if (dict[i] / 2 != entry.getKey()) {
                    res += (long) left_num * right_num;
                } else {
                    res += (long) left_num * (left_num - 1);
                }
            }
        }
        return (int) res / 2 % 1000_000_007;
    }
}
