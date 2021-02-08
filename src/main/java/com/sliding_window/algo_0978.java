package com.sliding_window;

/**
 * @author yb
 * @date: 2021-2-8
 * 978 最长湍流子数组
 */
public class algo_0978 {
    public int maxTurbulenceSize(int[] arr) {
        if(arr == null)
            return 0;
        if(arr.length <= 1)
            return arr.length;

        int left = 0, right = 0, res = 0;
        while(right < arr.length - 1){
            if(left == right){
                if(arr[left] == arr[left + 1]){
                    left ++;
                }
                right ++;
            } else {
                if(arr[right - 1] > arr[right] && arr[right] < arr[right + 1])
                    right ++;
                else if(arr[right - 1] < arr[right] && arr[right] > arr[right + 1])
                    right ++;
                else
                    left = right;
            }
            res = Math.max(res, right - left +1);
        }
        return res;
    }
}
