package com.algo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yb
 * @date: 2020-6-15
 * 101.对称二叉树
 */
public class algo_0101 {

    public boolean isSymmetric(TreeNode root) {
        return bfs(root,root);
    }

    private boolean bfs(TreeNode l, TreeNode r) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(l);
        queue.offer(r);
        while(!queue.isEmpty()){
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if(left == null && right == null)
                return true;
            if(left == null || right == null || left.val != right.val)
                return false;
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }

    public boolean isSymmetric2(TreeNode root) {
        return dfs(root,root);
    }

    private boolean dfs(TreeNode l, TreeNode r) {
        if(l == null && r == null)
            return true;
        if(l == null || r == null)
            return false;
        return (l.val == r.val) && dfs(l.left, r.right) && dfs(l.right, r.left);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}
