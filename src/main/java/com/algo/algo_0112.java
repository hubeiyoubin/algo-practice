package com.algo;
//给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例:
//给定如下二叉树，以及目标和 sum = 22，
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \      \
//        7    2      1
//
//
// 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
// Related Topics 树 深度优先搜索

import com.entity.TreeNode;

/**
 * @author yb
 * @date: 2020-12-11
 * 112. 路径总和
 */
public class algo_0112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        return dfs(root, 0, sum);
    }

    private boolean dfs(TreeNode node, int count, int sum) {
        if(node == null)
            return false;

        count = count + node.val;
        if(node.left == null && node.right == null && count == sum) {
            return true;
        }
        return dfs(node.left, count, sum) || dfs(node.right,count, sum);
    }
}
