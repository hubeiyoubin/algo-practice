package com.algo;

import com.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yb
 * @date: 2020-12-7
 */
//给定一个二叉树，返回它的中序 遍历。
//
// 示例:
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2]
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树 哈希表
public class algo_0094 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversalList(root, list);
        return list;
    }

    private void inorderTraversalList(TreeNode node, List<Integer> list) {
        if(node == null)
            return;

        TreeNode left = node.left;
        TreeNode right = node.right;
        inorderTraversalList(left, list);
        list.add(node.val);
        inorderTraversalList(right, list);
    }

    public static void main(String[] args) {
        Integer[] nums = {1,null,2,3};
        List list = new algo_0094().inorderTraversal(TreeNode.constructTree(nums));
        for(int i =0 ; i < list.size(); i ++){
            System.out.println(list.get(i));
        }
    }
}
