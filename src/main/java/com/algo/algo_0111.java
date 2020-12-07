package com.algo;

import com.entity.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author yb
 * @date: 2020-12-7
 */
//给定一个二叉树，找出其最小深度。
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
//
// 说明：叶子节点是指没有子节点的节点。
//
//
//
// 示例 1：
//
//
//输入：root = [3,9,20,null,null,15,7]
//输出：2
//
//
// 示例 2：
//
//
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
//
//
//
//
// 提示：
//
//
// 树中节点数的范围在 [0, 105] 内
// -1000 <= Node.val <= 1000
//
// Related Topics 树 深度优先搜索 广度优先搜索
public class algo_0111 {

    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;

        if(root.left == null && root.right == null)
            return 1;

        int min = Integer.MAX_VALUE;
        System.out.println("递 》》》" + min);
        if(root.left != null){
            min = Math.min(minDepth(root.left),min);
        }

        if(root.right != null) {
            min = Math.min(minDepth(root.right), min);
        }

        System.out.println("归《《《" + min);
        return min + 1;
    }


    public int minDepth_02(TreeNode root){
        if(root == null)
            return 0;
        int left = minDepth_02(root.left);
        int right = minDepth_02(root.right);
        if(left == 0 || right == 0){
            return left + right + 1;
        }
        return Math.min(left,right) + 1;
    }


    public int minDepth_03(TreeNode root){
        if(root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            while(size>0){
                TreeNode node =queue.poll();
                if(node.left == null && node.right ==null)
                    return depth;
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
                size--;
            }
            depth++;
        }
        return depth;
    }


    public static void main(String[] args) {
        Integer[] nums = {2,null,3,null,4,null,5,null,6};
        int min = new algo_0111().minDepth_03(TreeNode.constructTree(nums));
        System.out.println(min);
    }
}
