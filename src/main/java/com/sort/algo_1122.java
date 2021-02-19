package com.sort;

/**
 * @author yb
 * @date: 2021-2-19
 * 1122 数组的相对排序
 */
public class algo_1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int max = 0;
        for(int a : arr1){
            max = Math.max(a, max);
        }
        int[] freq = new int[max + 1];
        for(int index : arr1){
            freq[index] ++;
        }
        int[] res = new int[arr1.length];
        int k = 0;
        for(int x : arr2){
            while(freq[x] > 0){
                res[k ++] = x;
                freq[x] --;
            }
        }
        for(int i = 0; i < freq.length; i ++){
            while(freq[i] > 0){
                res[k ++] = i;
                freq[i] --;
            }
        }
        return res;
    }
}
