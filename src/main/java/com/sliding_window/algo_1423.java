package com.sliding_window;

/**
 * @author yb
 * @date: 2021-2-9
 * 1423 可获得的最大点数
 */
public class algo_1423 {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        int n = cardPoints.length - k;
        // 计算总和， 求总数 - 拿走的点数 的最小值
        for(int i = 0; i < cardPoints.length; i ++){
            sum += cardPoints[i];
        }
        if(n <= 0)
            return sum;
        int min = sum;
        int left = 0, right = 0, point = 0;
        while(right < cardPoints.length){
            point += cardPoints[right];
            right ++;
            while(right - left >= n){
                min = Math.min(point, min);
                point -= cardPoints[left];
                left ++;
            }
        }
        return sum - min;
    }
}
