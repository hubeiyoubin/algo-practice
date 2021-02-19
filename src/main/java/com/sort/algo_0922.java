package com.sort;

/**
 * @author yb
 * @date: 2021-2-19
 * 922 按奇偶排序数组 II
 */
public class algo_0922 {

    // 双指针法 time O(N) space O(1)
    public int[] sortArrayByParityII(int[] A) {
        int k = 1;
        for(int i = 0; i < A.length; i+=2){
            if((A[i] & 1) == 1){
                while((A[k] & 1) == 1)
                    k += 2;
                swap(A, i, k);
            }
        }
        return A;
    }
    private void swap(int[] arr, int start, int end){
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    // time O(N)   space O(N)
    public int[] sortArrayByParityII_(int[] A) {
        int[] res = new int[A.length];
        int m = 0,n = 1;
        for(int i = 0; i < A.length; i ++){
            if((A[i] & 1) == 0){
                res[m] = A[i];
                m += 2;
            } else {
                res[n] = A[i];
                n += 2;
            }
        }
        return res;
    }


    public int[] sortArrayByParityII_1(int[] A) {
        int[] odds = new int[A.length /2];
        int[] arr = new int[A.length /2];
        int i = 0, j = 0;
        for(int n = 0; n < A.length; n ++){
            // 奇数
            if((A[n] & 1) == 1){
                odds[i ++] = A[n];
            } else {
                arr[j ++] = A[n];
            }
        }
        int[] narr = new int[A.length];
        for(int k = 0; k < odds.length; k ++){
            narr[2*k] = arr[k];
            narr[2*k+1] = odds[k];
        }
        return narr;
    }
}
