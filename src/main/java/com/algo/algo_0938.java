package com.algo;

import com.entity.TreeNode;

/**
 * @author yb
 * @date: 2020-12-30
 * 938 二叉搜索树的范围和
 */
public class algo_0938 {
    int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        dfs(root, low, high);
        return sum;
    }
    private void dfs(TreeNode root, int low, int high){
        if(root == null)
            return;

        if(root.val >= low && root.val <= high){
            sum = sum + root.val;
        }
        if(root.val > low)
            dfs(root.left,low,high);
        if(root.val < high)
            dfs(root.right,low,high);
    }
}
