package com.algo;
//给定一个二叉树，原地将它展开为一个单链表。
//
//
//
// 例如，给定二叉树
//
//     1
//   / \
//  2   5
// / \   \
//3   4   6
//
// 将其展开为：
//
// 1
// \
//  2
//   \
//    3
//     \
//      4
//       \
//        5
//         \
//          6
// Related Topics 树 深度优先搜索

import com.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yb
 * @date: 2020-12-11
 * 114.二叉树展开为链表
 */
public class algo_0114 {
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        dfs(root, list);
        if(list.size() == 1)
            return;
        for(int i = 1; i < list.size(); i ++){
            root.right = list.get(i);
            root.left = null;
            root = root.right;
        }
    }

    private void dfs(TreeNode node, List<TreeNode> list) {
        if(node == null)
            return;
        list.add(node);
        dfs(node.left, list);
        dfs(node.right, list);
    }
}
