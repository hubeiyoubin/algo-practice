package com.algo;

import com.entity.TreeNode;

/**
 * @author yb
 * @date: 2021-1-15
 * 1325 删除给定值的叶子节点
 */
public class algo_1325 {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return dfs(root, target);
    }
    private TreeNode dfs(TreeNode node, int target){
        if(node == null)
            return null;
        if(node.left == null && node.right == null && node.val == target){
            return null;
        }
        TreeNode left = dfs(node.left, target);
        TreeNode right = dfs(node.right, target);
        if(left == null && right == null && node.val == target){
            return null;
        }
        node.left = left;
        node.right = right;
        return node;
    }
}
