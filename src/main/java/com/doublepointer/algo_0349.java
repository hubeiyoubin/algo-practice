package com.doublepointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @author yb
 * @date: 2021-1-29
 * 349 两个数组的交集
 */
public class algo_0349 {

    /**
     * 排序后，用双指针解法
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
            return new int[]{};
        if(nums1.length > nums2.length){
            return intersection(nums2,nums1);
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> list = new ArrayList<>();
        int p1=0, p2=0;
        while(p1 < nums1.length && p2 < nums2.length){
            if(nums1[p1] == nums2[p2]){
                if(list.size() == 0  || !list.get(list.size() - 1).equals(nums1[p1])) {
                    list.add(nums1[p1]);
                }
                p1++;
                p2++;
            } else if(nums1[p1] > nums2[p2]){
                p2++;
            } else {
                p1++;
            }
        }

        int[] arr = new int[list.size()];
        int k = 0;
        for(Integer in: list){
            arr[k++] = in;
        }
        return arr;
    }

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
