package com.algo;

import com.entity.TreeNode;

import java.util.HashMap;

/**
 * @author yb
 * @date: 2020-12-29
 * 865 具有所有最深节点的最小子树
 */
public class algo_0865 {
    int max_depth = -1;
    HashMap<TreeNode, Integer> map = new HashMap<>();
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root == null)
            return null;
        map.put(null,-1);
        dfs(root, null);
        return getDeepestTree(root);
    }
    private void dfs(TreeNode node, TreeNode parent){
        if(node == null)
            return;
        map.put(node, map.get(parent) + 1);
        max_depth = Math.max(max_depth, map.get(node));
        dfs(node.left, node);
        dfs(node.right, node);
    }
    private TreeNode getDeepestTree(TreeNode node){
        if(node == null || map.get(node) == max_depth)
            return node;
        TreeNode left = getDeepestTree(node.left);
        TreeNode right = getDeepestTree(node.right);
        if(left != null && right != null)
            return node;
        if(left != null)
            return left;
        if(right != null)
            return right;
        return null;
    }



    class Result {
        TreeNode node;
        int dist;
        Result(TreeNode n, int d) {
            node = n;
            dist = d;
        }
    }
    public TreeNode subtreeWithAllDeepest_(TreeNode root) {
        if(root == null)
            return null;
        return dfs(root).node;
    }
    private Result dfs(TreeNode node){
        if(node == null)
            return new Result(null, 0);
        Result left = dfs(node.left);
        Result right = dfs(node.right);
        return left.dist > right.dist ? new Result(left.node, left.dist + 1): left.dist == right.dist ? new Result(node, left.dist +1) :new Result(right.node, right.dist + 1);
    }

    public static void main(String[] args) {
        Integer[] nums = {3,5,1,6,2,0,8,null,null,7,4};
        TreeNode node = TreeNode.constructTree(nums);
        new algo_0865().subtreeWithAllDeepest(node);
    }
}
