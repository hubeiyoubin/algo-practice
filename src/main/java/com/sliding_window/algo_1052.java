package com.sliding_window;

/**
 * @author yb
 * @date: 2021-2-9
 * 1052 爱生气的书店老板
 *
 */
public class algo_1052 {

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        // 找出所有老板不生气时留下的顾客
        int res = 0;
        for(int i = 0; i < customers.length; i ++){
            if(grumpy[i] == 0){
                res += customers[i];
            }
        }
        //       System.out.println(res);
        // 然后用滑动窗口，找出 X分钟不生气，新增的顾客的最大值
        int left = 0, right = 0, max = 0;
        int add = 0;
        while(right < grumpy.length){
            if(grumpy[right] == 1){
                add += customers[right];
            }
            right ++;
//            System.out.println("--:"+left);
//            System.out.println(right);
            max = Math.max(max, add);
            if(right - left == X){
                if(grumpy[left] == 1)
                    add -= customers[left];
                left ++;
            }
        }
        return max + res;
    }
}
