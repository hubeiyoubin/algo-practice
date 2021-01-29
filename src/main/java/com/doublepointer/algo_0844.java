package com.doublepointer;

import java.util.Stack;

/**
 * @author yb
 * @date: 2021-1-29
 * 844 比较含退格的字符串
 */
public class algo_0844 {
    public boolean backspaceCompare(String S, String T) {
        // a##c
        if(S == null || T == null)
            return false;
        return toStr(S).equals(toStr(T));

    }
    private String toStr(String S){
        Stack<Character> stack = new Stack<>();
        for(char c : S.toCharArray()){
            if(c != '#')
                stack.add(c);
            if(!stack.isEmpty() && c == '#'){
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
