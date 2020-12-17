package com.algo;
//给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
//
// 例如，从根到叶子节点路径 1->2->3 代表数字 123。
//
// 计算从根到叶子节点生成的所有数字之和。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例 1:
//
// 输入: [1,2,3]
//    1
//   / \
//  2   3
//输出: 25
//解释:
//从根到叶子节点路径 1->2 代表数字 12.
//从根到叶子节点路径 1->3 代表数字 13.
//因此，数字总和 = 12 + 13 = 25.
//
// 示例 2:
//
// 输入: [4,9,0,5,1]
//    4
//   / \
//  9   0
// / \
//5   1
//输出: 1026
//解释:
//从根到叶子节点路径 4->9->5 代表数字 495.
//从根到叶子节点路径 4->9->1 代表数字 491.
//从根到叶子节点路径 4->0 代表数字 40.
//因此，数字总和 = 495 + 491 + 40 = 1026.

import com.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yb
 * @date: 2020-12-16
 * 129.求根到叶子节点的数字之和
 */
public class algo_0129 {
    List<Integer> list = new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        int sum = 0;
        for(Integer val: list){
            sum = sum + val;
        }
        return sum;
    }

    private void dfs(TreeNode root, int sum) {
        if(root == null) {
            return;
        }

        sum = sum * 10 + root.val;
        if(root.left == null && root.right == null){
            list.add(sum);
            System.out.println(sum);
        }
        dfs(root.left, sum);
        dfs(root.right, sum);
        System.out.println(sum);

    }
}
