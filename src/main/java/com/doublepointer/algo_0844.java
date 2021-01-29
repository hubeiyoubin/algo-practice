package com.doublepointer;

import java.util.Stack;

/**
 * @author yb
 * @date: 2021-1-29
 * 844 比较含退格的字符串
 */
public class algo_0844 {

    // 双指针解法
    public boolean backspaceCompare_(String S, String T) {
        // a##c  #a#c
        if(S == null || T == null)
            return false;
        int i = S.length() - 1, j = T.length() - 1;
        int sc = 0, tc = 0;
        while(i >=0 || j>= 0){
            while(i>=0){
                if(S.charAt(i) == '#'){
                    sc ++;
                    i --;
                } else if(sc > 0){
                    sc --;
                    i --;
                } else {
                    break;
                }
            }
            //System.out.println("i:"+i);
            while(j>=0){
                if(T.charAt(j) == '#'){
                    tc ++;
                    j --;
                } else if(tc > 0){
                    tc --;
                    j --;
                } else {
                    break;
                }
            }
            //System.out.println("j:"+j);
            if(i >=0 && j>= 0) {
                if (S.charAt(i) != T.charAt(j))
                    return false;
            } else if(i >=0 || j>= 0){
                return false;
            }
            i--;
            j--;
        }
        return true;
    }

    // 利用栈，还原字符串
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
