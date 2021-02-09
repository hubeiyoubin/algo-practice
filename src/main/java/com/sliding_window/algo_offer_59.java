package com.sliding_window;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author yb
 * @date: 2021-2-9
 * 剑指 Offer 59 - II 队列的最大值
 */
public class algo_offer_59 {
    class MaxQueue {
        Deque<Integer> max;
        Deque<Integer> que;

        public MaxQueue() {
            max = new LinkedList<>();
            que = new LinkedList<>();
        }

        public int max_value() {
            if(max.isEmpty())
                return -1;
            return max.peek();
        }

        public void push_back(int value) {
            while(!max.isEmpty() && max.peekLast() < value){
                max.pollLast();
            }
            max.offer(value);
            que.offer(value);
        }

        public int pop_front() {
            if(que.isEmpty())
                return -1;
            int res = que.poll();
            if(res == max.peek())
                max.poll();
            return res;
        }
    }

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
}
