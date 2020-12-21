package com.algo;

import com.entity.TreeNode;

import java.util.HashMap;
//给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节
//点为空。
//
// 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
//
// 示例 1:
//
//
//输入:
//
//           1
//         /   \
//        3     2
//       / \     \
//      5   3     9
//
//输出: 4
//解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
//
//
// 示例 2:
//
//
//输入:
//
//          1
//         /
//        3
//       / \
//      5   3
//
//输出: 2
//解释: 最大值出现在树的第 3 层，宽度为 2 (5,3)。
//
//
// 示例 3:
//
//
//输入:
//
//          1
//         / \
//        3   2
//       /
//      5
//
//输出: 2
//解释: 最大值出现在树的第 2 层，宽度为 2 (3,2)。
//
//
// 示例 4:
//
//
//输入:
//
//          1
//         / \
//        3   2
//       /     \
//      5       9
//     /         \
//    6           7
//输出: 8
//解释: 最大值出现在树的第 4 层，宽度为 8 (6,null,null,null,null,null,null,7)。
//
//
// 注意: 答案在32位有符号整数的表示范围内。
/**
 * @author : youbin
 * @date : 2020/12/20 13:28
 * 662 二叉树最大宽度
 */
public class algo_0662 {
    int res;
    HashMap<Integer, Integer> map = new HashMap<>();
    public int widthOfBinaryTree(TreeNode root) {
        res = 0;
        dfs(root, 0, 0);
        return res;
    }

    private void dfs(TreeNode root, int depth, int pos){
        if(root == null)
            return;
        if(!map.containsKey(depth)){
            map.put(depth, pos);
        }
        res = Math.max(res, pos - map.get(depth) + 1);
        dfs(root.left, depth +1, 2 * pos);
        dfs(root.right, depth +1, 2* pos +1);
    }
}
