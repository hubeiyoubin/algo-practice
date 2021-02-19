package com.sort;

import java.util.*;

/**
 * @author yb
 * @date: 2021-2-19
 * 710 黑名单中的随机数
 */
public class algo_0710 {

    //时间复杂度：预处理的时间复杂度为 O(B)，B为黑名单个数，随机选择的时间复杂度为 O(1)。
    class Solution {
        Random r;
        HashMap<Integer, Integer> map;
        int len;
        public Solution(int N, int[] blacklist) {
            List<Integer> list = new ArrayList<>();
            r = new Random();
            map = new HashMap<>();
            Set<Integer> set = new HashSet<>();
            len = N - blacklist.length;
            for(int k = 0; k < blacklist.length; k ++){
                set.add(blacklist[k]);
            }
            for(int i = len; i < N; i ++){
                if(!set.contains(i)){
                    list.add(i);
                }
            }
            int n = 0;
            //映射，将小于 len 的黑名单全部映射到大于 len 的白名单中
            for(int i = 0; i < blacklist.length; i ++){
                if(blacklist[i] < len) {
                    map.put(blacklist[i], list.get(n));
                    n ++;
                }
            }
        }

        public int pick() {
            int index = r.nextInt(len);
            if(map.containsKey(index))
                return map.get(index);
            return index;
        }
    }
}
