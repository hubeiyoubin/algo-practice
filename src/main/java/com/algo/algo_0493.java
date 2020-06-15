package com.algo;

/**
 * @author : youbin
 * @date : 2020/1/5 15:28
 * 493. 翻转对
 * 给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
 *
 * 你需要返回给定数组中的重要翻转对的数量。
 *
 * 示例 1:
 *
 * 输入: [1,3,2,3,1]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [2,4,3,5,1]
 * 输出: 3
 */
public class algo_0493 {
    public int reversePairs(int[] nums) {
        if(nums == null)
            return 0;
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int start, int end) {
        if(end <= start)
            return 0;
        int mid = start + (end - start) / 2;
        int pair = mergeSort(nums, start, mid) + mergeSort(nums, mid + 1,end);
        for(int i = start,j = mid + 1; i <= mid; i ++){
            while(j<=end && nums[i]/2.0 > nums[j]){
                j ++;
            }
            pair += j - (mid + 1);
        }
        merge(nums, start, mid, end);
        return pair;
    }

    private void merge(int[] nums, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        while(i <= mid && j <= end){
            temp[k++] = nums[i] <= nums[j] ? nums[i ++] : nums[j ++];
        }
        while(i <= mid)
            temp[k++] = nums[i++];
        while(j <= end)
            temp[k++] = nums[j++];
        for (int p = 0; p < temp.length; p++) {
            nums[start + p] = temp[p];
        }
    }


    /**
     * 第二种解法，标准的归并排序解法
     * @param nums
     * @param start
     * @param end
     * @return
     */
    private int mergeSort2(int[] nums, int start, int end) {
        if(end <= start)
            return 0;
        int mid = start + (end - start) / 2;
        int pair = mergeSort(nums, start, mid) + mergeSort(nums, mid + 1,end);
        int[] temp = new int[end - start + 1];
        int i = start, j = start, k = 0;
        for (int t = mid + 1; t <= end ; t++, k++) {
            while(i <= mid && nums[i] <= 2 * (long)nums[t])
                i ++;
            while(j <= mid && nums[j] <= nums[t])
                temp[k++] = nums[j++];

            temp[k] = nums[t];
            pair += mid - i + 1;
        }
        while(j <= mid){
            temp[k ++] = nums[j ++];
        }
        //Object src：源数组
        //int srcPos：源数组下标
        //Object dest：目标数组
        //int destPos：目标数组下标
        //int length：复制的长度 temp.length
        System.arraycopy(temp,0,nums,start,temp.length);
        return pair;
    }

}
