package com.algo;

import com.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author : youbin
 * @date : 2020/6/15 22:47
 */
public class algo_0107 {
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null)
            return list;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i =0; i < size; i ++){
                TreeNode node = q.poll();
                temp.add(node.val);
                if(node.left != null){
                   q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
            }
            list.add(0, temp);
        }
        return list;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        find(root, 1, list);
        return list;
    }

    private void find(TreeNode root, int level, List<List<Integer>> list) {
        if(root == null)
            return;
        if(level > list.size())
            list.add(0, new ArrayList<>());

        list.get(list.size() - level).add(root.val);
        find(root.left, level + 1, list);
        find(root.right, level + 1, list);
    }


}
