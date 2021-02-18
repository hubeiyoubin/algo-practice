package com.sort;

import java.util.Arrays;

/**
 * @author yb
 * @date: 2021-2-18
 * 324 摆动排序 II
 */
public class algo_0324 {
    public void wiggleSort(int[] nums) {
        int[] help = nums.clone(); //不能写成int[] help = nums,排序后两个数组都改变
        Arrays.sort(help);
        int N = nums.length;
        //比如123456
        for (int i = 1; i < nums.length; i += 2) {
            nums[i] = help[--N];
        }
        for (int i = 0; i < nums.length; i += 2) {
            nums[i] = help[--N]; //便利完成后 3 6 2 5 1 4
        }
    }
}
