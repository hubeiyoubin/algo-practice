package com.algo;

import com.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author yb
 * @date: 2020-12-16
 * 145.二叉树的后序遍历
 */
public class algo_0145 {

    // 利用栈 进行
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stackPost = new Stack<>();
        if(root == null)
            return list;

        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            stackPost.push(node);
            if(node.left != null) {
                stack.push(node.left);
            }
            if(node.right != null)
                stack.push(node.right);
        }
        while(!stackPost.isEmpty()){
            list.add(stackPost.pop().val);
        }
        return list;
    }

    public List<Integer> postorderTraversal_02(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list;
    }

    // 递归
    private void dfs(TreeNode root, List<Integer> list){
        if(root == null)
            return;

        dfs(root.left, list);
        dfs(root.right, list);
        list.add(root.val);
    }

    // 中序遍历 stack实现
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = root;
        while(!stack.isEmpty() || pre != null){
            while(pre !=null){
                stack.push(pre);
                pre = pre.left;
            }
            TreeNode left = stack.pop();
            list.add(left.val);

            TreeNode right = left.right;
            if(right != null) {
               pre = right;
            }

        }
        return list;
    }

    // 中序遍历 dfs 递归
    public List<Integer> inorderTraversal_02(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder_dfs(root, list);
        return list;
    }

    private void inorder_dfs(TreeNode root, List<Integer> list) {
        if(root == null)
            return;
        inorder_dfs(root.left, list);
        list.add(root.val);
        inorder_dfs(root.right, list);
    }
}
