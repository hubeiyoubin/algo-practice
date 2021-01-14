package com.algo;

import com.entity.TreeNode;

/**
 * @author yb
 * @date: 2021-1-14
 * 1302 层数最深叶子节点的和
 */
public class algo_1302 {
    int depth;
    int res;
    public int deepestLeavesSum(TreeNode root) {
        depth = 0;
        res = 0;
        dfs(root, 0 );
        return res;
    }
    private void dfs(TreeNode node, int dep){
        if(node == null)
            return;
        if(dep == depth){
            res = res + node.val;
        }
        if(dep > depth){
            depth = dep;
            res = node.val;
        }
        dfs(node.left, dep + 1);
        dfs(node.right, dep + 1);
    }
}
