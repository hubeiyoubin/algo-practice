package com.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author yb
 * @date: 2021-1-29
 * 350 两个数组的交集 II
 */
public class algo_0350 {


    /**
     *  排序后，双指针解法
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
            return new int[]{};
        if(nums1.length > nums2.length){
            return intersect(nums2,nums1);
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> list = new ArrayList<>();
        int p1=0, p2=0;
        while(p1 < nums1.length && p2 < nums2.length){
            if(nums1[p1] == nums2[p2]){
                list.add(nums1[p1]);
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

    public int[] intersect_1(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
            return new int[]{};
        if(nums1.length > nums2.length){
            return intersect_1(nums2,nums1);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums1.length; i++){
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for(int j=0; j<nums2.length; j++){
            if(map.getOrDefault(nums2[j],0) > 0){
                map.put(nums2[j], map.getOrDefault(nums2[j],0) - 1);
                list.add(nums2[j]);
            }
        }
        int[] arr = new int[list.size()];
        int k = 0;
        for(Integer in: list){
            arr[k++] = in;
        }
        return arr;
    }
}
