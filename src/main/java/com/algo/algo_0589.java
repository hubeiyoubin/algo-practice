package com.algo;

import com.entity.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author yb
 * @date: 2020-12-21
 * 589 N叉树的前序遍历
 */
public class algo_0589 {
    // 利用栈实现的迭代法
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        if(root != null)
            stack.push(root);
        while(!stack.isEmpty()){
            Node node = stack.pop();
            list.add(node.val);
            List<Node> childs = node.children;
            if(!childs.isEmpty()){
                for(int i=childs.size()-1; i>=0; i--){
                    stack.push(childs.get(i));
                }
            }
        }
        return list;
    }

    // dfs, 递归解法
    public List<Integer> preorder_(Node root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list;
    }
    private void dfs(Node root, List<Integer> list){
        if(root == null)
            return;
        list.add(root.val);
        for(Node child : root.children){
            dfs(child, list);
        }
    }
}
