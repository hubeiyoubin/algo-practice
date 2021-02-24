package com.sort;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author yb
 * @date: 2021-2-24
 * 1333 餐厅过滤器
 */
public class algo_1333 {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        return Stream.of(restaurants)
                .filter(r-> (veganFriendly==1?r[2]==veganFriendly:true) && r[4]<=maxDistance && r[3]<=maxPrice)
                //按照 rating 从高到低排序。如果 rating 相同，那么按 id 从高到低排序
                .sorted((r1,r2) -> r1[1]!=r2[1]?r2[1]-r1[1]:r2[0]-r1[0])
                .map(r->r[0])
                .collect(Collectors.toList());
    }
}
