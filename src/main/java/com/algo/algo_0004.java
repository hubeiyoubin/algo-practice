package com.algo;

/**
 * @date : 2019-11-8
 *
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class algo_0004 {

    //解法一, 时间复杂度 O(m+n)
    //简单粗暴，先将两个数组合并，两个有序数组的合并也是归并排序中的一部分。然后根据奇数，还是偶数，返回中位数
    public double findMedianSortedArrays_01(int[] nums1, int[] nums2) {
        int[] nums;
        int m = nums1.length;
        int n = nums2.length;
        nums = new int[m + n];
        if (m == 0) {
            if (n % 2 == 0) {
                return (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
            } else {

                return nums2[n / 2];
            }
        }
        if (n == 0) {
            if (m % 2 == 0) {
                return (nums1[m / 2 - 1] + nums1[m / 2]) / 2.0;
            } else {
                return nums1[m / 2];
            }
        }

        int count = 0;
        int i = 0, j = 0;
        while (count != (m + n)) {
            if (i == m) {
                while (j != n) {
                    nums[count++] = nums2[j++];
                }
                break;
            }
            if (j == n) {
                while (i != m) {
                    nums[count++] = nums1[i++];
                }
                break;
            }

            if (nums1[i] < nums2[j]) {
                nums[count++] = nums1[i++];
            } else {
                nums[count++] = nums2[j++];
            }
        }

        if (count % 2 == 0) {
            return (nums[count / 2 - 1] + nums[count / 2]) / 2.0;
        } else {
            return nums[count / 2];
        }
    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
    }

    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
        if (len1 == 0) return nums2[start2 + k - 1];

        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        }
        else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }



    public static double findMedianSortedArrays_03(int[] nums1, int[] nums2) {
        int len1 = 0;
        int len2 = 0;
        if(nums1 != null)
         len1 = nums1.length;
        if(nums2 != null)
         len2 = nums2.length;

        int[] num = new int[len1 + len2];

        if(len1 == 0){
            if(len2 % 2 != 0){
                return nums2[len2 / 2];
            }else{
                return (nums2[len2 / 2 - 1] + nums2[len2 / 2 ]) / 2.0;
            }
        }

        if(len2 == 0){
            if(len1 % 2 != 0){
                return nums1[len1 / 2];
            }else{
                return (nums1[len1 / 2 - 1] + nums1[len1 / 2 ]) / 2.0;
            }
        }

        int i = 0, j = 0;
        int count = 0;
        while(count != len1 + len2){
            if(i == len1){
                while(j != len2){
                    num[count] = nums2[j];
                    j ++;
                    count ++;
                }
                break;
            }

            if(j == len2){
                while(i != len1){
                    num[count] = nums1[i];
                    i ++;
                    count ++;
                }
                break;
            }

            if(nums1[i] < nums2[j]){
                num[count] = nums1[i];
                i ++;
            }else{
                num[count] = nums2[j];
                j ++;
            }
            count++;
        }

        System.out.println("count--"+count);
        return count % 2 == 0 ? (num[count / 2 - 1] + num[count / 2]) / 2.0 : num[count / 2];

    }

    public static void main(String[] args){
        int[] num1 = new int[]{2};
        int[] num2 = new int[]{1,6,7};
        System.out.println(findMedianSortedArrays_03(num2,num1));
    }
}
