package com.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * @date : 2019-11-22
 *
 * 22. 括号生成
 *
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 *
 */
public class algo_0022 {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generatePareth(list , n, "", 0, 0);
        return list;
    }

    private void generatePareth(List<String> list, int n, String s, int left, int  right) {
        if(s.length() == n * 2){
            list.add(s);
            return;
        }
        if(left < n) {
            generatePareth(list, n, s + "(", left + 1, right);
        }
        if(left > right){
            generatePareth(list, n, s+")", left, right + 1);
        }
    }

    public static void main(String[] args) {
        List<String> list = new algo_0022().generateParenthesis(2);
        System.out.println("括号组合数："+list.size());
        StringBuilder sb = new StringBuilder();
        sb.append("[ \n");
        for(int i = 0; i < list.size(); i ++){
            sb.append(list.get(i));
            if(list.size() - 1 != i)
            sb.append(",\n");
        }
        sb.append("\n ]");
        System.out.println(sb.toString());
    }
}
