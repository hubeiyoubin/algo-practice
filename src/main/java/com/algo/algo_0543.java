package com.algo;

import com.entity.TreeNode;

/**
 * @author yb
 * @date: 2020-12-18
 * 543. 二叉树的直径
 */
public class algo_0543 {

    int max;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        dfs(root);
        return max - 1;
    }

    private int dfs(TreeNode root){
        if(root == null)
            return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        max = Math.max(max, left + right + 1);
        return Math.max(left, right) + 1;
    }
}
