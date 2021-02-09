package com.sliding_window;

import java.util.Arrays;

/**
 * @author yb
 * @date: 2021-2-9
 * 1498 满足条件的子序列数目
 */
public class algo_1498 {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            if (nums[l] + nums[r] > target)
                r--;
            else {
                res = (int)((res + myPow(2, r - l)) % (1000000000 + 7));
                l++;
            }
        }
        return res;
    }
    //快速幂：防止long会溢出所以每一步都要mod
    //(a+b)modP=[(amodP)+(bmodP)]modP
    //(a×b)modP=[(amodP)×(bmodP)]modP
    private long myPow(int x, int n){
        if(n == 0) return 1;
        long t = x;
        long res = 1;
        while(n > 0){
            if((n & 1) == 1)
                res = (res * t) % (1000000000 + 7);
            t = (t * t) % (1000000000 + 7);
            n >>= 1;
        }
        return res % (1000000000 + 7);
    }
}
