package com.doublepointer;

/**
 * @author yb
 * @date: 2021-1-28
 * 88 合并两个有序数组
 */
public class algo_0088 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int right=m+n-1;
        int p1 = m-1, p2 = n-1;

        while(right >= 0 && p1 >=0 && p2>=0) {
            if (nums1[p1] >= nums2[p2]) {
                nums1[right] = nums1[p1];
                p1--;
            } else {
                nums1[right] = nums2[p2];
                p2--;
            }
            right--;
        }
        if(p1 == -1 && p2 != -1){
            for(int i=0; i<=right; i++){
                nums1[i] = nums2[i];
            }
        }
    }
}
