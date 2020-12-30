package com.algo;

import com.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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



    List<TreeNode> list_ = new ArrayList<>();
    public TreeNode increasingBST_(TreeNode root) {
        dfs(root);
        if(list_.size() == 0)
            return root;
        TreeNode first = list_.get(0);
        TreeNode node = first;
        for(int i=1; i<list_.size(); i++){
            node.left = null;
            node.right = list_.get(i);
            node = node.right;
        }
        node.left = null;
        return first;
    }


    /**
     * 中序遍历直接改变指针
     */
    TreeNode cur;
    public TreeNode increasingBST_03(TreeNode root) {
        TreeNode ans = new TreeNode(0);
        cur = ans;
        dfs_(root);
        return ans.right;
    }
    private void dfs_(TreeNode root){
        if(root == null)
            return;
        dfs_(root.left);
        root.left = null;
        cur.right = root;
        cur = root;
        dfs_(root.right);
    }

}
