package com.algo;

import com.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yb
 * @date: 2021-1-14
 * 1305 两棵二叉搜索树中的所有元素
 */
public class algo_1305 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        dfs(root1, list1);
        dfs(root2, list2);
        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        while(i < list1.size() || j < list2.size()){
            if(i < list1.size() && (j == list2.size() || list1.get(i) <= list2.get(j) )){
                list.add(list1.get(i));
                i ++;
            } else {
                list.add(list2.get(j));
                j ++;
            }
        }
        return list;
    }
    private void dfs(TreeNode root, List<Integer> list){
        if(root == null)
            return;
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }
}
