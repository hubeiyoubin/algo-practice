package com.algo;

import java.util.Stack;

/**
 * @date : 2020-1-6
 * 232. 用栈实现队列
 */
public class algo_0232 {
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    /** Initialize your data structure here. */
    public algo_0232() {
        inStack = new Stack();
        outStack = new Stack();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        inStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        checkOutStack();
        return outStack.pop();
    }

    private void checkOutStack() {
        if(outStack.isEmpty()){
            while(!inStack.isEmpty())
                outStack.push(inStack.pop());
        }
    }

    /** Get the front element. */
    public int peek() {
        checkOutStack();
        return outStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return outStack.isEmpty() && inStack.isEmpty();
    }
}
