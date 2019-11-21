package com.algo;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @date : 2019-11-21
 *
 * 20.有效的括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 *
 */
public class algo_0020 {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> map = new HashMap<>(3);
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        for(int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else{
                if(stack.isEmpty())
                    return false;
                if(stack.pop() != map.get(c))
                    return false;
            }
        }
        return stack.isEmpty();
    }
    public static String printStack(Stack<Character> stack){
        Stack<Character> copy = (Stack<Character>) stack.clone();
        StringBuilder sb = new StringBuilder("top:");
        while(!copy.isEmpty()){
            sb.append(copy.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(isValid("((({})[)(])"));

    }
}
