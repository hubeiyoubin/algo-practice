package com.algo;

import com.entity.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author yb
 * @date: 2020-12-30
 * 958 二叉树的完全性检验
 */
public class algo_0958 {
    public boolean isCompleteTree(TreeNode root) {
        Deque<TreeNode> que = new LinkedList<>();
        if(root != null)
            que.offer(root);
        while(!que.isEmpty()){
            TreeNode node =que.poll();
            if(node.left == null && node.right != null)
                return false;
            if(node.left != null)
                que.offer(node.left);
            if(node.right != null)
                que.offer(node.right);
        }
        return true;
    }
}
