package com.algo;

import java.util.Stack;

/**
 * @date : 2019-11-6
 */
/*
32-最长有效括号
给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。

        示例 1:

        输入: "(()"
        输出: 2
        解释: 最长有效括号子串为 "()"
        示例 2:

        输入: ")()())"
        输出: 4
        解释: 最长有效括号子串为 "()()"

        */

public class algo_0032 {

    public static int longestValidParentheses2(String s){
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < s.length(); i ++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }else{
                if(!stack.isEmpty())
                    stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    max = Math.max(max , i - stack.peek());
                    System.out.println("s--"+ s.substring(stack.peek() + 1,i + 1));
                }

            }
        }
        return max;
    }

    public static boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i ++){
           char c = s.charAt(i);
            if(c == '(')
                stack.push(c);
            else{
                if(stack.isEmpty() || stack.peek() != '(')
                    return  false;
                else
                    stack.pop();
            }
        }
        return stack.isEmpty();
    }

    //找出所有可能性，一个一个校验，找出最长的
    public static int longestValidParentheses_01(String s){
        int max = 0;
        //System.out.println("s -- "+ s);
        for(int i = 0; i < s.length(); i ++){
            for(int j = i + 2; j <= s.length(); j += 2){
                String s1 = s.substring(i,j);
                //System.out.println("s1 -- "+ s1);
                if(isValid(s1)){
                    max = Math.max(max,j - i);
                }
            }
        }
        return max;
    }

    public static int longestValidParentheses(String s){
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i = 0; i < s.length(); i ++){
            if('(' == s.charAt(i)){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()) {
                    stack.push(i);
                } else {
                    System.out.println(stack.peek());
                    max = Math.max(max, i - stack.peek());
                    System.out.println(s.substring(stack.peek() + 1, i + 1));
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        //System.out.println(longestValidParentheses_01("))()()(("));
        System.out.println(longestValidParentheses("()()"));

        //System.out.println("012345".substring(1,3));
    }
}
