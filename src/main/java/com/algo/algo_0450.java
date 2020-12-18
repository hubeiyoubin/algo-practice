package com.algo;

import com.entity.TreeNode;

/**
 * @author yb
 * @date: 2020-12-18
 * 450.删除二叉搜索树中的节点
 */
public class algo_0450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return null;

        return delete(root, key);
    }
    private TreeNode delete(TreeNode node, int key){
        if(node == null)
            return null;
        if(node.val > key) {
            node.left = delete(node.left, key);
            //return node;
        }else if(node.val < key) {
            node.right = delete(node.right, key);
            //return node;
        }else {
            if(node.left == null){
                node = node.right;
                //node.right = null;
                //return rightNode;
            }else if(node.right == null){
                node = node.left;
                //node.left = null;
                //return leftNode;
            } else {

                // 待删除节点左右子树均不为空的情况
                // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
                // 用这个节点顶替待删除节点的位置
                TreeNode moveNode = findMin(node.right);
                moveNode.right = removeMin(node.right);
                moveNode.left = node.left;
                node.left = null;
                node.right = null;
                //return moveNode;
                node = moveNode;
            }
        }
        return node;
    }
    private TreeNode findMin(TreeNode node){
        while(node.left != null)
            node = node.left;
        return node;
    }

    private TreeNode removeMin(TreeNode node){
        if(node.left == null){
            TreeNode rightNode = node.right;
            node.right = null;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }
}
