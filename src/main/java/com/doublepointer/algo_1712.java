package com.doublepointer;

/**
 * @author yb
 * @date: 2021-2-5
 * 1712 将数组分成三个子数组的方案数
 */
public class algo_1712 {
    public int waysToSplit(int[] nums) {
        int n = nums.length;
        int[] sum = new int[nums.length + 1];
        for(int i=1; i<sum.length; i++){
            sum[i] = sum[i-1] + nums[i-1];
        }

        int ave = sum[sum.length - 1] / 3;
        long res = 0;
        final int MOD = 1000000000 + 7;
        // 枚举第一段， 找出第二段可以切割的最大和最小位置
        for(int i = 1, j = 2, k = 2; sum[i] <= ave && i < sum.length - 2; i ++){
            j = Math.max(j, i + 1);
            k = Math.max(k, i + 1);
//            int j = i+1;
//            int k = i+1;
            // sum(right) >= sum(mid)，k最大为n-1，right保证要有一个数
            while(k <= n-1 && sum[n] - sum[k] >= sum[k] - sum[i]){
                k++;
            }
            // sum(mid) >= sum(left)
            while(j <= n-1 && sum[j] - sum[i] < sum[i]){
                j++;
            }
//
//            System.out.println("j:"+j);
//            System.out.println(k);
            if (j <= k) {
                res += k -j ;
            }
        }
        return (int) (res % MOD);
    }
}
