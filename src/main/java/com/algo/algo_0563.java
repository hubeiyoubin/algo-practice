package com.algo;

import com.entity.TreeNode;

/**
 * @author yb
 * @date: 2020-12-18
 * 563.二叉树的坡度
 */
public class algo_0563 {
    int sum = 0;
    public int findTilt(TreeNode root) {
        if(root == null)
            return 0;
        dfs(root);
        return sum;
    }

    private int dfs(TreeNode root){
        if(root == null)
            return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        sum = Math.abs(left - right) + sum;
        return left + right + root.val;
    }
}
