package com.algo;

import com.entity.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author yb
 * @date: 2020-12-21
 * 590 N叉树的后序遍历
 */
public class algo_0590 {

    // 迭代
    public List<Integer> postorder_(Node root) {
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Stack<Node> postStack = new Stack<>();
        if(root != null)
            stack.push(root);
        while(!stack.isEmpty()){
            Node node = stack.pop();
            postStack.push(node);
            List<Node> childs = node.children;
            if(!childs.isEmpty()){
                for(int i=0; i<childs.size(); i++){
                    stack.push(childs.get(i));
                }
            }
        }
        while(!postStack.isEmpty()){
            list.add(postStack.pop().val);
        }
        return list;

    }

    // dfs
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list;
    }
    private void dfs(Node root, List<Integer> list){
        if(root == null)
            return;
        for(Node child : root.children){
            dfs(child, list);
        }
        list.add(root.val);
    }
}
