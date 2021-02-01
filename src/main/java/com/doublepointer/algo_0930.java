package com.doublepointer;

/**
 * @author : youbin
 * @date : 2021/2/1 23:36
 * 930 和相同的二元子数组
 */
public class algo_0930 {

    /**
     * 枚举所有的 1，记录下标
     * @param A
     * @param S
     * @return
     */
    public int numSubarraysWithSum(int[] A, int S) {
        if(A == null || A.length == 0)
            return 0;
        int sum = 0;
        for(int x : A)
            sum += x;
        // 存一个初始值-1，再存一个最大的下标 A.length
        int[] indexs = new int[sum + 2];
        int t = 0;
        indexs[t++] = -1;
        for(int i = 0; i < A.length; i ++){
            if(A[i] == 1){
                indexs[t++] = i;
            }
        }
        indexs[t] = A.length;

        //  if(S == 0){
        //                    count += (ls-left) *(ls - left + 1) / 2;
        //                } else {
        //                    count += (ls - left + 1) * (rs -right + 1);
        //                }

        int res = 0;
        if(S == 0){
            for(int i = 0; i < indexs.length - 1; i ++){
                int ls = indexs[i];
                int rs = indexs[i+1];
                res += (rs-ls) * (rs - ls -1) / 2;
            }
            return res;
        }
        for(int i = 1; i < indexs.length - S; i ++){
            int k = i + S - 1; // [i, k] 和为S， k - i = S -1;
            res += (indexs[i]-indexs[i-1]) * (indexs[k+1] -indexs[k]);
        }
        return res;
    }
}
