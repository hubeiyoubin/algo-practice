package com.doublepointer;

import java.util.Arrays;

/**
 * @author yb
 * @date: 2021-2-1
 * 881 救生艇
 */
public class algo_0881 {

    /**
     *  木桶排序 + 双指针 + 贪心算法
     * @param people
     * @param limit
     * @return
     */
    public int numRescueBoats(int[] people, int limit) {
        if(people == null || people.length == 0)
            return 0;
        // 按重量进行木桶排序
        int[] weight = new int[limit];
        for(int i = 0; i < people.length; i++){
            weight[people[i] - 1] ++;
        }
        int i = 0, j = weight.length - 1;
        int count = 0;
        while(i <= j){
            // 去除为 0 的数
            while(i <= j && weight[i] <= 0)
                i++;
            while(i <= j && weight[j] <= 0)
                j--;
            if(i > j)
                break;
            if(i + j + 2 <= limit){
//                System.out.println(i);
//                System.out.println(j);
                weight[i] --;
                weight[j] --;
                count ++;
            } else {
                weight[j] --;
                count ++;
            }
        }
        return count;
    }

    // O(nlogn) 排序(快排) + 双指针 + 贪心算法
    public int numRescueBoats_(int[] people, int limit) {
        if(people == null || people.length == 0)
            return 0;
        Arrays.sort(people);
        int i = 0, j = people.length - 1;
        int count=0;
        while(i <= j){
            if(people[i] + people[j] <= limit){
                i ++;
            }
            j --;
            count ++;
        }
        return count;
    }
}
