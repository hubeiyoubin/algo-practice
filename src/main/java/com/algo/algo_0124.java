package com.algo;
//给定一个非空二叉树，返回其最大路径和。
//
// 本题中，路径被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
//
//
//
// 示例 1：
//
// 输入：[1,2,3]
//
//       1
//      / \
//     2   3
//
//输出：6
//
//
// 示例 2：
//
// 输入：[-10,9,20,null,null,15,7]
//
//   -10
//   / \
//  9  20
//    /  \
//   15   7
//
//输出：42

import com.entity.TreeNode;

/**
 * @author yb
 * @date: 2020-12-16
 * 124. 二叉树中的最大路径和
 */
public class algo_0124 {
    private Integer max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
         dfs(root);
         return max;
    }

    private int dfs(TreeNode root) {
        if(root == null)
            return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);
        int lmr = root.val + Math.max(0, left) + Math.max(0, right);
        int ret = root.val+ Math.max(0, Math.max(left, right));
        max = Math.max(max, Math.max(lmr, ret));
        return ret;
    }

}
