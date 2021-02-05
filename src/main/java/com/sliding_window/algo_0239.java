package com.sliding_window;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author yb
 * @date: 2021-2-5
 * 239 滑动窗口最大值
 *
 *
 * //输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * //输出：[3,3,5,5,6,7]
 * //解释：
 * //滑动窗口的位置                最大值
 * //---------------               -----
 * //[1  3  -1] -3  5  3  6  7       3
 * // 1 [3  -1  -3] 5  3  6  7       3
 * // 1  3 [-1  -3  5] 3  6  7       5
 * // 1  3  -1 [-3  5  3] 6  7       5
 * // 1  3  -1  -3 [5  3  6] 7       6
 * // 1  3  -1  -3  5 [3  6  7]      7
 */
public class algo_0239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
            }
        });

        for(int i = 0; i < k; i ++){
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        int j = k;
        while(j < nums.length) {
            pq.offer(new int[]{nums[j], j});
            while (pq.peek()[1] <= j - k) {
                pq.poll();
            }
            ans[j - k + 1] = pq.peek()[0];
            j++;
        }
        return ans;
    }

}
