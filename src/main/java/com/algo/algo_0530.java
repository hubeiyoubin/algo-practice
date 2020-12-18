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


    /**
     *  dfs ,边进行中序遍历，边比较
     */
    int pre = -1;
    int min = Integer.MAX_VALUE;
    public int getMinimumDifference_(TreeNode root) {
        dfs(root);
        return min;
    }
    private void dfs(TreeNode root){
        if(root == null)
            return;
        dfs(root.left);
        if(pre == -1) {
            pre = root.val;
        }else{
            min = Math.min(min, Math.abs(root.val - pre));
            pre = root.val;
        }
        dfs(root.right);
    }
}
