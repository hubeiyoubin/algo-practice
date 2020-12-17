package com.algo;

import com.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
//
// 说明：
//你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
//
// 示例 1:
//
// 输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 1
//
// 示例 2:
//
// 输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 3
//
// 进阶：
//如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
// Related Topics 树 二分查找
/**
 * @author yb
 * @date: 2020-12-17
 */
public class algo_0230 {

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode left = stack.pop();
            k--;
            if (k == 0)
                return left.val;
            if(left.right != null)
                cur = left.right;
        }
        return -1;
    }

    // dfs
    public int kthSmallest_(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list.get(k - 1);
    }

    private void dfs(TreeNode root, List<Integer> list){
        if(root == null)
            return;
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }
}
