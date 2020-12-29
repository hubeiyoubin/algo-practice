package com.algo;

import com.entity.TreeNode;

import java.util.LinkedList;

/**
 * @author yb
 * @date: 2020-12-29
 * 897 递增顺序查找树
 */
public class algo_0897 {
    LinkedList<TreeNode> list = new LinkedList<>();
    public TreeNode increasingBST(TreeNode root) {
        dfs(root);
        if(list.size() == 0)
            return root;
        TreeNode first = list.pollFirst();
        TreeNode node = first;
        while(node != null){
            node.left = null;
            node.right = list.pollFirst();
            node = node.right;
        }
        return first;
    }
    private void dfs(TreeNode root){
        if(root == null)
            return;
        dfs(root.left);
        list.add(root);
        dfs(root.right);
    }
}
