package com.two_pointers;

import java.util.Arrays;

/**
 * @author yb
 * @date: 2021-2-1
 * 923 三数之和的多种可能
 */
public class algo_0923 {
    public int threeSumMulti(int[] arr, int target) {
        if(arr == null || arr.length < 3)
            return 0;
        int count = 0;
        int MOD = 1000000007;
        Arrays.sort(arr);
        for(int i = 0; i < arr.length-2; i++){
            int num = target - arr[i];
            int j = i +1; int k = arr.length - 1;
            while(j < k) {

                //System.out.println("j:" + j);
                //System.out.println("A:" + arr[i] + "--" + arr[j] + "--" + arr[k]);
                if (arr[j] + arr[k] > num) {
                    k--;
                } else if( arr[j] + arr[k] < num){
                    j++;
                } else if (arr[j] + arr[k] == num && arr[j] != arr[k]) {
                    int left = 1, right = 1;
                    while (j+1 < k && arr[j] == arr[j+1]) {
                        left++;
                        j++;
                    }
                    while (k-1 > j && arr[k] == arr[k-1]) {
                        right++;
                        k--;
                    }

                    count += left * right;
                    count %= MOD;
                    j++;
                    k--;
                } else if (arr[j] + arr[k] == num && arr[j] == arr[k]) {
                    // M = k - j + 1
                    // We contributed M * (M-1) / 2 pairs.
                    count += (k-j+1) * (k-j) / 2;
                    count %= MOD;
                    break;
                }
            }

        }
        return count;
    }
}
