package com.algo;

import com.entity.TreeNode;

/**
 * @author yb
 * @date: 2020-12-31
 * 1008 前序遍历构造二叉搜索树
 */
public class algo_1008 {

    /**
     *  往右查找，找出第一个比跟节点大的值，从此位置开始是 right tree，找不到则说明没有right tree
     */
    int[] preorder;
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder == null || preorder.length == 0)
            return null;

        this.preorder = preorder;
        return dfs(0, preorder.length - 1);
    }
    private TreeNode dfs(int start, int end){
        if(start > end)
            return null;
        int val = preorder[start];
        TreeNode node = new TreeNode(val);
        int right_index = start;
        for(int i=start+1; i<=end; i++){
            if(preorder[i] > val){
                right_index = i;
                break;
            }
        }
        if(right_index > start) {
            node.left = dfs(start + 1, right_index - 1);
            node.right = dfs(right_index, end);
        } else {
            node.left = dfs(start + 1, end);
        }
        return node;
    }
}
