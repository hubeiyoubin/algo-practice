package com.algo;

import com.entity.TreeNode;

/**
 * @author yb
 * @date: 2020-12-21
 * 700 二叉搜索树中的搜索
 */
public class algo_0700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null)
            return null;
        if(root.val == val)
            return root;
        if(root.val > val)
            return searchBST(root.left, val);
        else
            return searchBST(root.right, val);
    }
}
