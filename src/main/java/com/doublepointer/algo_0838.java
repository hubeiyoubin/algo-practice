package com.doublepointer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yb
 * @date: 2021-2-1
 * 838 推多米诺
 */
public class algo_0838 {
    public String pushDominoes(String dominoes) {
        if(dominoes == null || dominoes.length() == 0)
            return dominoes;
        dominoes = "L" + dominoes + "R";
        char[] domin = dominoes.toCharArray();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < domin.length; i ++){
            if(domin[i] == 'L')
                list.add( -(i+1));
            else if(domin[i] == 'R')
                list.add( i + 1);
        }
        for(int i = 1; i < list.size(); i ++){
            int start = list.get(i - 1);
            int end = list.get(i);
//            System.out.println(start);
//            System.out.println(end);
//            System.out.println("------------");
            // L...L
            if(start < 0 && end < 0){
                int left = - start;
                int right = - end - 1;
                while(left < right){
                    domin[left] = 'L';
                    left ++;
                }
            }
            // R...R
            if(start > 0 && end > 0){
                int left = start;
                int right = end - 1;
                while(left < right){
                    domin[left] = 'R';
                    left ++;
                }
            }
            // L...R 不用处理
            // R...L
            if(start > 0 && end < 0){
                int left = start;
                int right = - end -2;
                while(left < right){
                    domin[left] = 'R';
                    domin[right] = 'L';
                    left ++;
                    right --;
                }
            }
        }
        return String.valueOf(domin).substring(1, domin.length - 1);
    }
}
