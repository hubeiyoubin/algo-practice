package com.algo;

import com.entity.TreeNode;
//给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
//
// 注意：两个节点之间的路径长度由它们之间的边数表示。
//
// 示例 1:
//
// 输入:
//
//
//              5
//             / \
//            4   5
//           / \   \
//          1   1   5
//
//
// 输出:
//
//
//2
//
//
// 示例 2:
//
// 输入:
//
//
//              1
//             / \
//            4   5
//           / \   \
//          4   4   5
//
//
// 输出:
//
//
//2
//
//
// 注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。
// Related Topics 树 递归
/**
 * @author yb
 * @date: 2020-12-21
 * 687. 最长同值路径
 */
public class algo_0687 {
    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        if(root == null)
            return 0;
        dfs(root);
        return max;
    }
    private int dfs(TreeNode root){
        if(root == null)
            return 0;
        int maxRes = 0;
        int left = dfs(root.left);
        int right = dfs(root.right);

        // root + left +right
        if(root.left != null && root.left.val == root.val && root.right != null && root.right.val == root.val)
            max = Math.max(max,left + right + 2);
        // root + left
        if(root.left != null && root.left.val == root.val)
            maxRes = left + 1;
        // root + right
        if(root.right != null && root.right.val == root.val)
            maxRes = Math.max(maxRes, right + 1);
        // 取三者最大值
        max = Math.max(max, maxRes);
        // 返回 root+(left or right)
        return maxRes;
    }
}
