package com.algo;

import com.entity.TreeNode;

/**
 * @author yb
 * @date: 2020-12-31
 * 1026 节点与其祖先之间的最大差值
 */
public class algo_1026 {


    /**
     * 求差的绝对值为最大，只要和祖先元素中最大值和最小值比较，取其中更大的一个即可
     */
    int value = 0;
    public int maxAncestorDiff(TreeNode root) {
        dfs( root, root.val, root.val);
        return value;
    }

    private void dfs(TreeNode root, int max, int min){
        if(root == null)
            return;
        value =Math.max(Math.max(Math.abs(root.val - max), Math.abs(root.val - min)), value);
        max = root.val > max ? root.val : max;
        min = root.val > min ? min : root.val;
        System.out.println("val:"+root.val +" -- max:" + max + " -- min:"+ min);
        dfs(root.left, max, min);
        dfs(root.right,max, min);
    }


    /**
     * 暴力破解， 逐个比较
     */
    int max = 0;
    public int maxAncestorDiff_(TreeNode root) {
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
