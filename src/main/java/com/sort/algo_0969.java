package com.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yb
 * @date: 2021-2-22
 * 969 煎饼排序
 */
public class algo_0969 {

    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> res = new ArrayList<>();
        if(arr == null || arr.length == 0)
            return res;
        int n = arr.length - 1;
        for(int i = arr.length - 1; i >= 0; i --){
            //System.out.println(Arrays.toString(arr));
            int maxIndex = getMaxIndex(arr, i);
            if(maxIndex != i){
                pancake(arr, 0, maxIndex);
                res.add(maxIndex + 1);
                pancake(arr,0, n);
                res.add(n + 1);
            }
            n --;
        }
        return res;
    }

    private void pancake(int[] arr, int start, int end){
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start ++;
            end --;
        }
    }

    private int getMaxIndex(int[] arr, int end){
        int max = arr[end];
        int maxIndex = end;
        for(int i = end; i >= 0; i --){
            if(arr[i] > max){
                max = arr[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
