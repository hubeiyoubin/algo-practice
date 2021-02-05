package com.two_pointers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @author : youbin
 * @date : 2021/1/31 17:17
 * 632 最小区间
 */
public class algo_0632 {
    public int[] smallestRange(List<List<Integer>> nums) {
        if(nums == null || nums.size() == 0)
            return new int[]{};
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.size(); i ++){
            for(Integer in : nums.get(i)){
                List<Integer> array = map.getOrDefault(in, new ArrayList<>());
                array.add(i);
                list.add(in);
                map.put(in, array);
                max = Math.max(max, in);
                min = Math.min(min, in);
            }
        }
        Collections.sort(list);
        int[] arr = new int[nums.size()];
        int left = 0, right = 0;
        int res_left = 0, res_right = list.size() - 1;
        int valid = 0;
        while(right < list.size()){
            int temp = list.get(right);
            if(map.containsKey(temp)){
                for(Integer i : map.get(temp)){
                    arr[i] ++;
                    if(arr[i] == 1){
                        valid ++;
                    }
                }

                while(valid == nums.size()) {
                    if(list.get(right) - list.get(left) < list.get(res_right) - list.get(res_left)){
                        res_left = left;
                        res_right = right;
                    }
//                    System.out.println("left:"+ left );
//                    System.out.println("right:"+right);
//                    System.out.println("res_left:"+ res_left);
//                    System.out.println("res_right:"+res_right);
                    int left_temp = list.get(left);
                    if (map.containsKey(left_temp)) {
                        for (Integer i : map.get(left_temp)) {
//                            System.out.println(i);
//                            System.out.println(arr[i]);
                            arr[i] --;
                            if (arr[i] == 0) {
                                valid--;
                            }
                        }
                    }
                    left ++;
                }
            }
            right ++;
        }
        return new int[]{list.get(res_left), list.get(res_right)};
    }
}
