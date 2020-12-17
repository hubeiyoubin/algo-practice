package com.algo;

import com.entity.TreeNode;
//给出一个完全二叉树，求出该树的节点个数。
//
// 说明：
//
// 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为
//第 h 层，则该层包含 1~ 2h 个节点。
//
// 示例:
//
// 输入:
//    1
//   / \
//  2   3
// / \  /
//4  5 6
//
//输出: 6
/**
 * @author yb
 * @date: 2020-12-17
 */
public class algo_0222 {

    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;
        int leftHigh = getHighLeft(root);
        int rightHigh = getHighRight(root);
        if(leftHigh == rightHigh){
            return (int)Math.pow(2,leftHigh) - 1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    private int getHighLeft(TreeNode node) {
        int high = 0;
        while(node != null){
            high ++;
            node = node.left;
        }
        return high;
    }
    private int getHighRight(TreeNode node) {
        int high = 0;
        while(node != null){
            high ++;
            node = node.right;
        }
        return high;
    }


    public int countNodes_02(TreeNode root) {
        return dfs(root);
    }
    private int dfs(TreeNode node){
        if(node == null)
            return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        return left + right + 1;
    }
}
