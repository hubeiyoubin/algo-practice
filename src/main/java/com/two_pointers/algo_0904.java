package com.two_pointers;

import java.util.HashMap;

/**
 * @author yb
 * @date: 2021-2-1
 * 904 水果成篮
 */
public class algo_0904 {
    public int totalFruit(int[] tree) {
        if(tree == null || tree.length == 0)
            return 0;
        int left = 0, right = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int len = 0;
        while(right < tree.length){
            int fu = tree[right];
            right ++;
            map.put(fu, map.getOrDefault(fu, 0) + 1);
            while(map.size() >= 3){
                int lu = tree[left];
                left ++;
                map.put(lu, map.getOrDefault(lu, 0) - 1);
                if(map.getOrDefault(lu, 0) <= 0){
                    // System.out.println("lu:"+lu);
                    map.remove(lu);
                }
            }
//            System.out.println(left);
//            System.out.println(right);
            len = Math.max(len, right - left);
        }
        return len;
    }
}
