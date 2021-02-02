package com.doublepointer;

import java.util.Arrays;

/**
 * @author yb
 * @date: 2021-2-2
 * 948 令牌放置
 */
public class algo_0948 {

    // 排序 后 + 双指针 +贪心算法解决
    public int bagOfTokensScore(int[] tokens, int P) {
        if(tokens == null || tokens.length == 0)
            return 0;
        Arrays.sort(tokens);
        int left = 0, right = tokens.length - 1;
        int count = 0;
        int res = 0;
        while(left <= right && (P > tokens[left] || count > 0)){
            while(left <= right && tokens[left] <= P){
                P = P - tokens[left];
                count ++;
                left ++;
            }
            // System.out.println("l:"+left);

            res = Math.max(count, res);
            if(left <= right && count > 0){
                //System.out.println("r:"+right);
                P = P + tokens[right];
                right --;
                count --;
            }
        }
        return res;
    }
}
