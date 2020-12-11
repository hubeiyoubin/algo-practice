package com.algo;

//给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例:
//给定如下二叉树，以及目标和 sum = 22，
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
//
//
// 返回:
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
//
// Related Topics 树 深度优先搜索

import com.entity.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yb
 * @date: 2020-12-11
 * 113. 路径总和2
 */
public class algo_0113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> lists = new ArrayList<>();
        Deque<Integer> que = new LinkedList<>();
        dfs(root, sum, que, lists);
        return lists;
    }

    private void dfs(TreeNode node, int sum,Deque<Integer> que,List<List<Integer>> lists) {
        if(node == null)
            return;

        sum = sum - node.val;
        que.addLast(node.val);
        if(node.left == null && node.right == null && sum == 0){
            lists.add(new ArrayList<>(que));
        }
        dfs(node.left, sum, que, lists);
        dfs(node.right, sum, que, lists);
        que.pollLast();
    }
}
