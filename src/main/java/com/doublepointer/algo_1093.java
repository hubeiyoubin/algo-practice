package com.doublepointer;

/**
 * @author yb
 * @date: 2021-2-2
 * 1093 大样本统计
 */
public class algo_1093 {
    public double[] sampleStats(int[] count) {
        //最小值、最大值、平均值、中位数和众数
        double min = 255.00000,max = 0.00000, ave = 0.00000,many = 0.00000,mid = 0.00000;
        int left = 0, right = count.length - 1;
        double sum = 0;
        double amount = 0;
        int num_count = 0, num_index = -1;
        int countL = 0, countR = 0;
        int min_count = 0, max_count = 0;
        while(left < right){
            // 最小值
            while(left <= right && count[left] == 0){
                left ++;
            }
            if(min_count == 0) {
                min = (double) left;
                min_count ++;
            }
            // 最大值
            while(left <= right && count[right] == 0){
                right --;
            }
            if(max_count == 0) {
                max = (double) right;
                max_count ++;
            }

            // 众数
            if(count[left] > num_count || count[right] > num_count){
                if(count[left] > count[right]){
                    num_count = count[left];
                    num_index = left;
                } else {
                    num_count = count[right];
                    num_index = right;
                }
            }


            // 中位数
            if (countL == 0) {
                countL = count[left];
            }
            if (countR == 0) {
                countR = count[right];
            }

            if (countL == countR) {
                // 总和 和 个数
                amount += count[left] + count[right];
                sum += left * count[left] + right * count[right];
                countL = 0;
                countR = 0;
                left++;
                right--;
            } else if (countL > countR) {
                sum += count[right] * right;
                amount += count[right];
                countL = countL - countR;
                countR = 0;
                right--;
            } else {
                sum += count[left] * left;
                amount += count[left];
                countR = countR - countL;
                countL = 0;
                left++;
            }
            ave = (double)sum / (double)amount * 1.00000;
        }
        if (countL == 0 && countR == 0) {
            mid = (left + right) * 1.0 / 2;
        } else if (countR == 0) {
            mid = left;
        } else {
            mid = right;
        }
        if (left != right) {
            sum += countL * left + countR * right;
            amount += (countL + countR);
        } else {
            sum += count[left] * left;
            amount += count[left];
        }

        ave = (double)sum / (double)amount * 1.00000;
        many = (double) num_index;
        double[] d = new double[5];
        //double min = 255.00000,max = 0.00000, ave = 0.00000,many = 0.00000,mid = 0.00000;
        d[0] = min; d[1] = max; d[2] = ave; d[3] = mid ; d[4] = many;
        return d;
    }
}
