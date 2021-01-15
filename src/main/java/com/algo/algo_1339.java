package com.algo;

import com.entity.TreeNode;

/**
 * @author yb
 * @date: 2021-1-15
 * 1339 分裂二叉树的最大乘积
 */
public class algo_1339 {

    private long sum, mid;
    long res;
    public int maxProduct(TreeNode root) {
        sum = 0; mid = 0;
        dfs(root);
        dfs2(root);
        //System.out.println(sum - mid);
        //System.out.println(mid);
        //return (mid  %  1000000007) *  ((sum-mid) % 1000000007);
        return (int)(res % 1000000007);
    }
    private void dfs(TreeNode node){
        if(node == null)
            return;
        sum = sum + node.val;
        dfs(node.left);
        dfs(node.right);
    }
    private long dfs2(TreeNode node){
        if(node == null)
            return 0;
        long cur = dfs2(node.left) + dfs2(node.right) + node.val;
        // 取最接近中间的值
//        if(Math.abs(cur*2 - sum) < Math.abs(mid*2 - sum)){
//            mid = cur;
//        }
        res = Math.max(res, (sum-cur) * cur);
        return cur;
    }
}

