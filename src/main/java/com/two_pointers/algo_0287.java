package com.two_pointers;

import java.util.HashMap;

/**
 * @author : youbin
 * @date : 2021/1/28 23:37
 * 287 寻找重复数
 */
public class algo_0287 {

    // Floyd 判圈算法
    // 时间O(n) 空间 O(1)
    public int findDuplicate_2(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    // 二分法  时间O(nlogn) 空间 O(1)
    //如果测试用例的数组中 target 出现了两次，
    // 其余的数各出现了一次，这个时候肯定满足上文提及的性质，
    // 因为小于 target 的数 i 满足 cnt[i]=i，大于等于 target 的数 jj 满足 cnt[j]=j+1

    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int l = 1, r = n - 1, ans = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            int cnt = 0;
            for (int i = 0; i < n; ++i) {
                if (nums[i] <= mid) {
                    cnt++;
                }
            }
            if (cnt <= mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }

    // 时间O(n) 空间 O(n)
    public int findDuplicate_1(int[] nums) {
        if(nums == null || nums.length < 2)
            return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if(map.getOrDefault(nums[i], 0) == 2)
                return nums[i];
        }
        return 0;
    }
}
