package com.algo;

import com.entity.TreeNode;

/**
 * @author : youbin
 * @date : 2020/12/21 21:51
 *
 * 814 二叉树剪枝
 */
public class algo_0814 {

    // 后序遍历
    public TreeNode pruneTree(TreeNode root) {
        TreeNode node = dfs(root);
        if(node != null && node.left == null && node.right == null && node.val == 0){
            return null;
        }
        return node;
    }

    private TreeNode dfs(TreeNode root){
        if(root == null)
            return null;

        TreeNode left = dfs(root.left);
        TreeNode right = dfs(root.right);
        if(left != null && left.left == null && left.right == null && left.val == 0){
            root.left = null;
        }
        if(right != null && right.left == null && right.right == null && right.val == 0){
            root.right = null;
        }
        return root;
    }
}
