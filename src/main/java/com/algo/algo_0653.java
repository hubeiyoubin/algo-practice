package com.algo;

import com.entity.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
//给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
//
// 案例 1:
//
//
//输入:
//    5
//   / \
//  3   6
// / \   \
//2   4   7
//
//Target = 9
//
//输出: True
//
//
//
//
// 案例 2:
//
//
//输入:
//    5
//   / \
//  3   6
// / \   \
//2   4   7
//
//Target = 28
//
//输出: False
/**
 * @author : youbin
 * @date : 2020/12/19 13:52
 *
 * 653 两数之和 IV - 输入 BST
 */
public class algo_0653 {

    // 前序遍历 + set
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        if(root == null)
            return false;
        return dfs(root, set, k);
    }

    private boolean dfs(TreeNode root, HashSet<Integer> set, int k){
        if(root == null)
            return false;

        if(set.contains(k - root.val))
            return true;

        set.add(root.val);
        return dfs(root.left, set, k) || dfs(root.right, set, k);

    }

    // 中序遍历 + 双指针
    public boolean findTarget_02(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        if(root == null)
            return false;
        dfs(root, list);
        int i = 0, j = list.size() - 1;
        while(i < j){
            int left = list.get(i);
            int right = list.get(j);
            if(left + right < k)
                i ++;
            if(left + right > k)
                j --;
            if(left + right == k)
                return true;
        }
        return false;
    }

    private void dfs(TreeNode root, List<Integer> list){
        if(root == null)
            return;

        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }
}
