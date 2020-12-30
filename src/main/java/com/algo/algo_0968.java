package com.algo;

import com.entity.TreeNode;

/**
 * @author yb
 * @date: 2020-12-30
 * 968 监控二叉树
 */
public class algo_0968 {

    /**
     *  todo
     *  dp 动态规划
     */


    /**
     * 贪心算法， 后序遍历，局部最优推出全局最优
     */
    int res = 0;
    public int minCameraCover(TreeNode root) {
        int post = dfs(root);
        return post == 2 ? res + 1 : res;
    }
    private int dfs(TreeNode root){
        if(root == null)
            return 1;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int ret = Math.min(left,right) + 1;
        if(Math.max(left,right) == 2){
            ret = 0;
            res ++;
        }
        return ret;
    }
}
