package com.algo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @date : 2020-1-6
 * 226. 翻转二叉树
 */
public class algo_0226 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

    private class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) {
              val = x;
          }
    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
        }
        return root;
    }

    public TreeNode invertTree2(TreeNode root) {
	   if (root == null) return root;

	   TreeNode tmp = root.left;
	   root.left = root.right;
	   root.right = tmp;

       invertTree2(root.left);
       invertTree2(root.right);

       return root;
   }

	public TreeNode invertTree3(TreeNode root) {
	   if (root == null) return root;

       invertTree3(root.left);
       invertTree3(root.right);

	   TreeNode tmp = root.left;
	   root.left = root.right;
	   root.right = tmp;

       return root;
    }

	public TreeNode invertTree4(TreeNode root) {
	   if (root == null) return root;

       invertTree4(root.left);

	   TreeNode tmp = root.left;
	   root.left = root.right;
	   root.right = tmp;

       invertTree4(root.left);

       return root;
    }

}
