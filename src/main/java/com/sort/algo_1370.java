package com.sort;

/**
 * @author yb
 * @date: 2021-2-25
 * 1370 上升下降字符串
 */
public class algo_1370 {

    // 木桶排序
    public String sortString(String s) {
        int[] arr = new int[26];
        for(char c: s.toCharArray()){
            arr[c - 'a'] ++;
        }
        StringBuilder sb = new StringBuilder();
        while(sb.length() < s.length()){
            for(int i = 0; i < arr.length; i ++){
                if(arr[i] > 0) {
                    sb.append((char)(i + 'a'));
                    arr[i] --;
                }
            }
            for(int j = arr.length - 1; j >=0; j --){
                if(arr[j] > 0){
                    sb.append((char)(j + 'a'));
                    arr[j] --;
                }
            }
        }
        return sb.toString();
    }
}
