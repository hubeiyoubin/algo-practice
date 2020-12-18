package com.algo;

import com.entity.TreeNode;

/**
 * @author yb
 * @date: 2020-12-18
 */
public class algo_0538 {
    private int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root == null)
            return null;
        dfs(root);
        return root;
    }
    private void dfs(TreeNode root){
        if(root == null)
            return;
        dfs(root.right);
        sum = root.val + sum;
        root.val = sum;
        dfs(root.left);

    }
}
