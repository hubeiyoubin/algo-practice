package com.algo;

import com.entity.TreeNode;

/**
 * @author : youbin
 * @date : 2020/12/21 21:33
 * 783 二叉搜索树节点最小距离
 */
public class algo_0783 {

    // 中序遍历，从小到大，一一比较
    int min;
    int pre;
    public int minDiffInBST(TreeNode root) {
        min = Integer.MAX_VALUE;
        pre = Integer.MAX_VALUE;
        dfs(root);
        return min;
    }
    private void dfs(TreeNode root){
        if(root == null)
            return;

        dfs(root.left);
        min = Math.min(min, Math.abs(root.val - pre));
        pre = root.val;
        dfs(root.right);
    }
}
