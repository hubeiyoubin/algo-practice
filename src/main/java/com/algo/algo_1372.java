package com.algo;

import com.entity.TreeNode;

/**
 * @author yb
 * @date: 2021-1-18
 * 1372 二叉树中的最长交错路径
 */
public class algo_1372 {
    int maxRes;
    public int longestZigZag(TreeNode root) {
        maxRes = 0;
        dfs(root, false, 0);
        dfs(root, true, 0);
        return maxRes;
    }

    private void dfs(TreeNode node, boolean isLeft, int len){
        if(node == null)
            return;
        maxRes = Math.max(maxRes, len);
        if(isLeft){
            dfs(node.left, true, 1);
            dfs(node.right, false, len + 1);
        }
        if(!isLeft){
            dfs(node.left, true, len +1);
            dfs(node.right, false, 1);
        }
    }
}
