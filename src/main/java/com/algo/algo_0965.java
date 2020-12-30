package com.algo;

import com.entity.TreeNode;

/**
 * @author yb
 * @date: 2020-12-30
 * 965 单值二叉树
 */
public class algo_0965 {
    int val = -1;
    public boolean isUnivalTree(TreeNode root) {
        if(root == null)
            return true;
        if(val != -1 && val != root.val){
            return false;
        }
        val = root.val;
        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }
}
