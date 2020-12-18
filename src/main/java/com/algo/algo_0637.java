package com.algo;

import com.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
//
//
//
// 示例 1：
//
// 输入：
//    3
//   / \
//  9  20
//    /  \
//   15   7
//输出：[3, 14.5, 11]
//解释：
//第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
//
//
//
//
// 提示：
//
//
// 节点值的范围在32位有符号整数范围内。
/**
 * @author : youbin
 * @date : 2020/12/18 23:22
 * 637 二叉树的层平均值
 */
public class algo_0637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        if(root != null)
            que.offer(root);

        while(!que.isEmpty()){
            int size = que.size();
            double sum = 0.0d;
            for(int i = 0; i < size; i ++){
                TreeNode node = que.poll();
                if(node.left != null)
                    que.offer(node.left);
                if(node.right != null)
                    que.offer(node.right);
                sum += node.val;
            }
            list.add(sum / size);
        }
        return list;
    }
}
