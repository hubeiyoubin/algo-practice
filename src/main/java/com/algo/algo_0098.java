package com.algo;

/**
 * @author yb
 * @date: 2020-12-8
 */
//给定一个二叉树，判断其是否是一个有效的二叉搜索树。
//
// 假设一个二叉搜索树具有如下特征：
//
//
// 节点的左子树只包含小于当前节点的数。
// 节点的右子树只包含大于当前节点的数。
// 所有左子树和右子树自身必须也是二叉搜索树。
//
//
// 示例 1:
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
//
//
// 示例 2:
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
//
// Related Topics 树 深度优先搜索 递归
// 👍 851 👎 0

import com.entity.TreeNode;

import java.util.Stack;

/**
 * 98.验证二叉搜索树
 */
public class algo_0098 {
    public boolean isValidBST(TreeNode root) {
        if(root == null || (root.left == null && root.right == null))
            return true;

        return bfs(root);
    }

    private boolean bfs(TreeNode node) {
        if(node ==  null)
            return true;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        TreeNode pre = null;
        while(node != null || !stack.isEmpty()){
            while(node != null){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if(pre != null && pre.val >= node.val)
                return false;

            pre = node;
            node = node.right;

        }
        return true;
    }

    private boolean dfs(TreeNode node, Integer high, Integer low) {
        if(node == null)
            return true;

        int val = node.val;
        if(high != null && val >= high)
            return false;

        if(low != null && val <= low)
            return false;

        return dfs(node.left, val, low) && dfs(node.right,high,val);
    }
}
