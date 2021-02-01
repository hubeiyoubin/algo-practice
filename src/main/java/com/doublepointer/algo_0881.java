package com.doublepointer;

import java.util.Arrays;

/**
 * @author yb
 * @date: 2021-2-1
 * 881 救生艇
 */
public class algo_0881 {
    public int numRescueBoats(int[] people, int limit) {
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
