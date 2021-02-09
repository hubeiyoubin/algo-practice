package com.sliding_window;

import java.util.Arrays;

/**
 * @author yb
 * @date: 2021-2-9
 * 1040 移动石子直到连续 II
 * // todo 有点难理解
 */
public class algo_1040 {
    /**
     * 最终的最大移动次数为：max(A[n-1]-A[1]-n+2, A[n-2]-A[0]-n+2)
     *
     *
     * 最小移动次数
     * 使用滑动窗口来记录最小移动次数，当窗口内的石子个数大于n时，我们需要缩小窗口。already_stone来统计窗口内的石子数，剩下来的石子数n-already_stone全部用来移动。注意特殊情况就是类似3,4,5,6,10这种前n-1个石子连续，第n个石子不连续，但是我们不能直接将10移到2，应该是3移到8，10移到7，需要两步完成。
     *
     * @param stones
     * @return
     */
    public int[] numMovesStonesII(int[] stones) {
        Arrays.sort(stones);
        int n=stones.length;
        int minMove=n;
        for(int i=0,j=0;j<n;j++) {
            //当前窗口的大小大于n
            while(stones[j]-stones[i]+1>n)
                i++;

            //当前窗口的石子个数
            int already_stone=(j-i+1);

            //前n-1个石子的顺序连续，最后一个石子不连续，需要移动2步。
            //比如3 4 5 6 10，我们不能直接将10变为2，而是将3变为8，然后10变为7来移动
            if (already_stone==n-1 &&  stones[j]-stones[i]+1==n-1)
                minMove=Math.min(minMove,2);
            else
                minMove=Math.min(minMove,n-already_stone);

        }
        return new int[]{minMove,Math.max(stones[n-1]-stones[1]-n+2, stones[n-2]-stones[0]-n+2)};
    }
}
