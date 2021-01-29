package com.doublepointer;

import java.util.HashSet;

/**
 * @author yb
 * @date: 2021-1-29
 * 349 两个数组的交集
 */
public class algo_0349 {

    // set O(m+n) 
    public int[] intersection_1(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
            return new int[]{};
        if(nums1.length > nums2.length){
            return intersection_1(nums2,nums1);
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<nums1.length; i++){
            set.add(nums1[i]);
        }
        HashSet<Integer> res = new HashSet<>();
        for(int j=0; j<nums2.length; j++){
            if(set.contains(nums2[j])){
                res.add(nums2[j]);
            }
            if(res.size() == set.size())
                break;
        }
        int[] arr = new int[res.size()];
        int k = 0;
        for(Integer in: res){
            arr[k++] = in;
        }
        return arr;
    }
}
