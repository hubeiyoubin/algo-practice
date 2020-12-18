package com.algo;

import com.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yb
 * @date: 2020-12-18
 * 530. 二叉搜索树的最小绝对差
 */
public class algo_0530 {
    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < list.size() - 1; i++){
            res = Math.min(res, Math.abs(list.get(i) - list.get(i + 1)));
        }
        return res;
    }
    private void dfs(TreeNode root, List<Integer> list){
        if(root == null)
            return;
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }
}
