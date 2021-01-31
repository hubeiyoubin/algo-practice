package com.doublepointer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : youbin
 * @date : 2021/1/31 21:31
 * 763 划分字母区间
 */
public class algo_0763 {
    public List<Integer> partitionLabels(String S) {
        int[] maxIndex = new int[26];
        for(int i = 0; i < S.length(); i++){
            maxIndex[S.charAt(i) - 'a'] = Math.max(maxIndex[S.charAt(i) - 'a'], i);
        }
        int start = 0, max = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i<S.length(); i++){
            max =  Math.max(max, maxIndex[S.charAt(i) - 'a']);
            if(i == max){
                list.add(i - start+1);
                start = i + 1;
            }
        }
        return list;
    }
}
