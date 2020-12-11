package com.algo;

import com.entity.TreeNode;
//给定一个二叉树，判断它是否是高度平衡的二叉树。
//
// 本题中，一棵高度平衡二叉树定义为：
//
//
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
//
//
//
//
// 示例 1：
//
//
//输入：root = [3,9,20,null,null,15,7]
//输出：true
//
//
// 示例 2：
//
//
//输入：root = [1,2,2,3,3,null,null,4,4]
//输出：false
//
//
// 示例 3：
//
//
//输入：root = []
//输出：true
//
//
//
//
// 提示：
//
//
// 树中的节点数在范围 [0, 5000] 内
// -104 <= Node.val <= 104
/**
 * @author : youbin
 * @date : 2020/6/17 20:53
 * 110 平衡二叉树
 */
public class algo_0110 {
    // 自底向上
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        return balanceHeight(root) != -1;
    }

    private int balanceHeight(TreeNode root) {
        if(root == null)
            return 0;
        int left = balanceHeight(root.left);
        if(left == -1)
            return -1;
        int right = balanceHeight(root.right);
        if(right == -1)
            return -1;
        return Math.abs(left - right)  < 2 ? Math.max(left ,right)  + 1 : -1;
    }


    // 自顶向下
    public boolean isBalanced2(TreeNode root) {
        if(root == null)
            return true;

        return Math.abs(depth(root.left) - depth(root.right)) <= 1
                && isBalanced2(root.left)
                && isBalanced2(root.right);
    }

    private int depth(TreeNode node) {
        if(node == null)
            return 0;
        return Math.max(depth(node.left),depth(node.right)) + 1;
    }
}

