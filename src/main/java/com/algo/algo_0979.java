package com.algo;

import com.entity.TreeNode;

/**
 * @author yb
 * @date: 2020-12-30
 * 979 在二叉树中分配硬币
 */
public class algo_0979 {
    int res;
    public int distributeCoins(TreeNode root) {
        res = 0;
        dfs(root);
        return res;
    }
    private int dfs(TreeNode node){
        if(node == null)
            return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        res = res + Math.abs(left) + Math.abs(right);
        return left + right + node.val - 1;
    }
}
