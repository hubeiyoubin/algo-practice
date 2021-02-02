package com.doublepointer;

/**
 * @author yb
 * @date: 2021-2-2
 * 1004 最大连续1的个数 III
 */
public class algo_1004 {

    public int longestOnes(int[] A, int K) {
        //转换问题， 滑动窗口内最多有K个0，求滑动窗口最大的长度
        if(A == null || A.length == 0)
            return 0;
        // 0 的个数
        int count = 0, len = 0;
        int left = 0, right = 0;
        while(right < A.length){
            if(A[right] == 0) {
                count++;
            }
            right ++;
            while(count > K){
                if(A[left] == 0){
                    count --;
                }
                left ++;
            }
            len = Math.max(right - left, len);
        }
        return len;
    }
}
