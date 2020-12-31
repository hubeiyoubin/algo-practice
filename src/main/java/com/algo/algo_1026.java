package com.algo;

import com.entity.TreeNode;

/**
 * @author yb
 * @date: 2020-12-31
 * 1026 节点与其祖先之间的最大差值
 */
public class algo_1026 {

    /**
     * 暴力破解， 逐个比较
     */
    int max = 0;
    public int maxAncestorDiff(TreeNode root) {
        mdfs(root);
        return max;
    }
    private void mdfs(TreeNode root){
        if(root == null)
            return;
        dfs(root, root.val);
        mdfs(root.left);
        mdfs(root.right);
    }

    private int dfs(TreeNode root, int cur){
        if(root == null)
            return -1;
        int left = dfs(root.left, cur);
        int right = dfs(root.right, cur);
        if(left != -1)
            max = Math.max(max, Math.abs(cur-left));

        if(right != -1)
            max = Math.max(max, Math.abs(cur-right));

        return root.val;
    }
}
