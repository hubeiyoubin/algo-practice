package com.algo;

import com.entity.TreeNode;

/**
 * @author yb
 * @date: 2020-12-31
 * 998 最大二叉树 II
 */
public class algo_0998 {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if(root == null)
            return null;
        return dfs(root, val);
    }
    private TreeNode dfs(TreeNode root, int val){
        if(root == null || root.val < val){
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        } else {
            root.right = dfs(root.right,val);
            return root;
        }
    }
}
