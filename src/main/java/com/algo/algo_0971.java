package com.algo;

import com.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yb
 * @date: 2020-12-30
 * 971 翻转二叉树以匹配先序遍历
 */
public class algo_0971 {
    List<Integer> list;
    int index;
    int[] voyage;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        list = new ArrayList<>();
        index = 0;
        this.voyage = voyage;
        dfs(root);
        if(!list.isEmpty() && list.get(0) == -1){
            list.clear();
            list.add(-1);
        }
        return list;
    }
    private void dfs(TreeNode node){
        if(node == null)
            return;
        if(node.val != voyage[index++]){
            list.clear();
            list.add(-1);
            return;
        }
        if(index < voyage.length && node.left != null && node.left.val != voyage[index]){
            list.add(node.val);
            dfs(node.right);
            dfs(node.left);
        }else{
            dfs(node.left);
            dfs(node.right);
        }
    }
}
