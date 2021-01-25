package com.algo;

import com.entity.TreeNode;

import java.util.LinkedList;

/**
 * @author yb
 * @date: 2021-1-25
 * 297 二叉树的序列化与反序列化
 */
public class algo_0297 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }
    private void dfs(TreeNode root, StringBuilder sb){
        if(root == null) {
            sb.append("#,");
            return;
        }
        sb.append(root.val + ",");
        dfs(root.left, sb);
        dfs(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        for(String s: data.split(",")){
            nodes.addLast(s);
        }
        return deserialize(nodes);
    }
    private TreeNode deserialize(LinkedList<String> nodes){
        if(nodes.isEmpty())
            return null;
        String str = nodes.removeFirst();
        if("#".equals(str)){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(str));
        TreeNode left = deserialize(nodes);
        TreeNode right = deserialize(nodes);
        root.left = left;
        root.right = right;
        return root;
    }
}
