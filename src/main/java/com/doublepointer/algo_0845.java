package com.doublepointer;

/**
 * @author yb
 * @date: 2021-2-1
 * 845 数组中的最长山脉
 */
public class algo_0845 {

    // 找出所有山顶， 并记录左右两边山脚到山顶距离
    public int longestMountain(int[] arr) {
        if(arr == null || arr.length < 2)
            return 0;
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        for(int i = 1; i < arr.length; i++){
            left[i] = arr[i - 1] < arr[i] ? left[i - 1] + 1 : 0;
        }
        for(int j = arr.length - 2; j > 0; j --){
            right[j] = arr[j + 1] < arr[j] ? right[j + 1] + 1 : 0;
        }
        int res = 0;
        for(int i = 1; i < arr.length - 1; i ++){
            if(left[i] > 0 && right[i] > 0){
                res = Math.max(res, left[i] + right[i] + 1);
            }
        }
        return res;
    }
}
