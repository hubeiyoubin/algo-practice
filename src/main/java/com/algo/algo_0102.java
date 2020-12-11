package com.algo;

/**
 * @author yb
 * @date: 2020-12-9
 */
//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
//
//
//
// 示例：
//二叉树：[3,9,20,null,null,15,7],
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回其层次遍历结果：
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
//
// Related Topics 树 广度优先搜索
// 👍 718 👎 0

import com.entity.TreeNode;

import java.util.*;

/**
 * 102. 二叉树的层序遍历
 */
public class algo_0102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if(root != null)
            queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> nums = new ArrayList<>();
            for(int i = 0; i < size; i ++){
                TreeNode node = queue.poll();
                nums.add(node.val);

                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
            }
            lists.add(nums);
        }
        return lists;
    }

    public List<List<Integer>> levelOrder_02(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        dfs_02(root, 0, lists);
        return lists;
    }

    private void dfs_02(TreeNode node, int depth, List<List<Integer>> lists) {
        if(node == null)
            return;

        if(lists.size() < depth + 1){
            List<Integer> nums = new ArrayList<>();
            nums.add(node.val);
        } else {
            lists.get(depth).add(node.val);
        }
        dfs_02(node.left,depth + 1, lists);
        dfs_02(node.right, depth + 1, lists);
    }
}
