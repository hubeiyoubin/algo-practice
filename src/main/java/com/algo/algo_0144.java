package com.algo;

import com.entity.TreeNode;

import java.util.*;

/**
 * @author yb
 * @date: 2020-12-16
 * 144.二叉树的前序遍历
 */
public class algo_0144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null)
            return list;

        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            list.add(node.val);
            if(node.right != null)
                stack.push(node.right);
            if(node.left != null)
                stack.push(node.left);
        }
        return list;
    }

    public List<Integer> preorderTraversal_02(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list;
    }
    // dfs 深度搜索
    private void dfs(TreeNode root, List<Integer> list){
        if(root == null)
            return;
        list.add(root.val);
        dfs(root.left, list);
        dfs(root.right, list);
    }
}
