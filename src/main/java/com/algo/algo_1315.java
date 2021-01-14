package com.algo;

import com.entity.TreeNode;

/**
 * @author yb
 * @date: 2021-1-14
 * 1315 祖父节点值为偶数的节点和
 */
public class algo_1315 {
    int res;
    public int sumEvenGrandparent(TreeNode root) {
        res = 0;
        dfs(1, 1, root);
        return res;
    }
    private void dfs(int gfVal, int parentVal, TreeNode node){
        if(node == null)
            return;
        if((gfVal&1) == 0){
            res = res + node.val;
        }
        dfs(parentVal, node.val, node.left);
        dfs(parentVal, node.val, node.right);
    }
}
