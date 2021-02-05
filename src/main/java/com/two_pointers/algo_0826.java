package com.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author : youbin
 * @date : 2021/1/31 22:03
 * 826 安排工作以达到最大收益
 */
public class algo_0826 {

    /**
     *  排序 + 双指针
     * @param difficulty
     * @param profit
     * @param worker
     * @return
     */
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        List<Work> list = new ArrayList<>();
        for(int i = 0; i < difficulty.length; i ++){
            list.add(new Work(difficulty[i], profit[i]));
        }
        Collections.sort(list);
        Arrays.sort(worker);

        int idx1 = 0, idx2 = 0, maxVal = 0, ans = 0;

        while (idx1 < list.size() && idx2 < worker.length) {
            if (list.get(idx1).diff <= worker[idx2]) {
                maxVal = Math.max(maxVal, list.get(idx1).pro);
                idx1++;
            } else {
                ans += maxVal;
                idx2++;
            }
        }
        // 剩余未安排工作的工人均可取得最大利润
        ans += (worker.length - idx2) * maxVal;
        return ans;
    }
    class Work implements Comparable<Work>{
        int diff;
        int pro;
        public Work(int diff, int pro){
            this.diff = diff;
            this.pro = pro;
        }

        @Override
        public int compareTo(Work o) {
            return this.diff - o.diff;
        }
    }


    // 暴力解法
    public int maxProfitAssignment_(int[] difficulty, int[] profit, int[] worker) {
        int res = 0;
        int i = 0;
        while(i < worker.length) {
            int pf = 0;
            for (int j = 0; j < difficulty.length; j++) {
                if(difficulty[j] > worker[i])
                    continue;
                pf = Math.max(profit[j], pf);

            }
            //System.out.println(pf);
            res += pf;
            i ++;
        }
        return res;
    }
}
