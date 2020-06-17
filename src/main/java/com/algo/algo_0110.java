package com.algo;

import com.entity.TreeNode;

/**
 * @author : youbin
 * @date : 2020/6/17 20:53
 * 110 平衡二叉树
 */
public class algo_0110 {
    // 自底向上
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        return balanceHeight(root) != -1;
    }

    private int balanceHeight(TreeNode root) {
        if(root == null)
            return 0;
        int left = balanceHeight(root.left);
        if(left == -1)
            return -1;
        int right = balanceHeight(root.right);
        if(right == -1)
            return -1;
        return Math.abs(left - right)  < 2 ? Math.max(left ,right)  + 1 : -1;
    }


    // 自顶向下
    public boolean isBalanced2(TreeNode root) {
        if(root == null)
            return true;

        return Math.abs(depth(root.left) - depth(root.right)) <= 1
                && isBalanced2(root.left)
                && isBalanced2(root.right);
    }

    private int depth(TreeNode node) {
        if(node == null)
            return 0;
        return Math.max(depth(node.left),depth(node.right)) + 1;
    }
}

