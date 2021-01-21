package com.algo;

import com.entity.TreeNode;

import java.util.HashSet;

/**
 * @author yb
 * @date: 2021-1-21
 * 1457 二叉树中的伪回文路径
 */
public class algo_1457 {
    int res;
    public int pseudoPalindromicPaths (TreeNode root) {
        if(root == null)
            return 0;
        res = 0;
        dfs(root, new HashSet<>(), 0);
        return res;
    }
    private void dfs(TreeNode node, HashSet<Integer> set, int count){
        if(node == null)
            return;
        count ++;
        if(!set.contains(node.val)){
            set.add(node.val);
        } else {
            set.remove(node.val);
        }
        if(node.left == null && node.right == null){
            if(set.size() == 0 && count % 2 == 0){
                res = res + 1;
            }
            if(set.size() == 1 && count % 2 != 0){
                res = res + 1;
            }
        }
        dfs(node.left, new HashSet<>(set), count);
        dfs(node.right, new HashSet<>(set), count);
    }
}
