package com.algo;

import com.entity.TreeNode;

/**
 * @author yb
 * @date: 2021-1-14
 * 1145 二叉树着色游戏
 */
public class algo_1145 {
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        int left, right;
        left = 0; right = 0;
        TreeNode xNode = findXNode(root, x);
        if(xNode != null) {
            left = dfs(xNode.left);
            right = dfs(xNode.right);
        }
        int parent = n - left - right - 1;
        if(left > n/2 ||right > n/2 || parent > n/2)
            return true;
        return false;
    }
    private TreeNode findXNode(TreeNode node, int x){
        if(node == null)
            return null;
        if(node.val == x)
            return node;
        TreeNode left = findXNode(node.left, x);
        TreeNode right = findXNode(node.right, x);
        if(left != null)
            return left;
        if(right != null)
            return right;
        return null;
    }
    private int dfs(TreeNode node){
        if(node == null)
            return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        return left + right + 1;
    }
}
