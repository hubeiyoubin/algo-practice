package com.algo;

import com.entity.TreeNode;

import java.util.*;

/**
 * @author yb
 * @date: 2020-12-30
 * 958 二叉树的完全性检验
 */
public class algo_0958 {

    /**
     *  记录node及其下标，判断最后一个元素的下标与list的大小
     * @param root
     * @return
     */
    public boolean isCompleteTree(TreeNode root) {
        List<TreeNode> list = new ArrayList();
        HashMap<TreeNode,Integer> map = new HashMap<>();
        list.add(root);
        map.put(root,0);
        int i = 0;
        while(i < list.size()){
            TreeNode node = list.get(i++);
            if (node != null) {
                list.add(node.left);
                map.put(node.left, map.get(node) * 2 + 1);
                list.add(node.right);
                map.put(node.right, map.get(node) * 2 + 2);
            }
        }
        return list.size() - 1 == map.get(list.get(i - 1));
    }

    /**
     * 按层次遍历树，如果是完全二叉树，就不可以出现空之后还有节点的情况
     * 以下是两种不同写法
     * @param root
     * @return
     */
    public boolean isCompleteTree_02(TreeNode root) {
        Deque<TreeNode> que = new LinkedList<>();
        if(root != null)
            que.offer(root);
        while(!que.isEmpty()){
            TreeNode node = que.poll();
            if(node == null)
                break;
            if(node.left == null && node.right != null)
                return false;
            que.offer(node.left);
            que.offer(node.right);
        }
        while (!que.isEmpty() && que.peek() == null) {
            que.poll();
        }
        return que.isEmpty();
    }

// 按层次遍历树，如果是完全二叉树，就不可以出现空之后还有节点的情况
    public boolean isCompleteTree_(TreeNode root) {
        List<TreeNode> list = new ArrayList();
        Deque<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()){
            TreeNode node = que.poll();
            list.add(node);
            if(node == null)
                continue;
            que.offer(node.left);
            que.offer(node.right);
        }
        TreeNode cur = root;
        for(TreeNode node : list){
            if(cur == null && node != null)
                return false;
            cur = node;
        }
        return true;
    }



}
