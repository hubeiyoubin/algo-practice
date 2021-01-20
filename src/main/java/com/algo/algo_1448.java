package com.algo;

import com.entity.TreeNode;

/**
 * @author yb
 * @date: 2021-1-20
 * 1448 统计二叉树中好节点的数目
 */
public class algo_1448 {
    int res;
    public int goodNodes(TreeNode root) {
        if(root == null)
            return 0;
        res = 0;
        dfs(root, root.val);
        return res;
    }
    private void dfs(TreeNode root, int max){
        if(root == null)
            return;
        if(root.val >= max){
            res = res + 1;
            max = root.val;
        }
        dfs(root.left, max);
        dfs(root.right,max);
    }
}
