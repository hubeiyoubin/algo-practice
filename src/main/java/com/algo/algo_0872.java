package com.algo;

import com.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yb
 * @date: 2020-12-22
 * 872 叶子相似的树
 */
public class algo_0872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(root1 == null || root2 == null)
            return root1 == null && root2 == null;

        Queue<TreeNode> que1 = new LinkedList<>();
        Queue<TreeNode> que2 = new LinkedList<>();
        if(root1 != null && root2 != null){
            que1.offer(root1);
            que2.offer(root2);
        }
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        while(!que1.isEmpty() || !que2.isEmpty()){
            if(!que1.isEmpty()) {
                TreeNode node1 = que1.poll();
                if (node1.left == null && node1.right == null) {
                    list1.add(node1.val);
                }
                if (node1.left != null)
                    que1.offer(node1.left);
                if (node1.right != null)
                    que1.offer(node1.right);
            }
            if(!que2.isEmpty()) {
                TreeNode node2 = que2.poll();
                if (node2.left == null && node2.right == null) {
                    list2.add(node2.val);
                }
                if (node2.left != null)
                    que2.offer(node2.left);
                if (node2.right != null)
                    que2.offer(node2.right);
            }
        }
        if(list1.size() != list2.size())
            return false;
        for(int i=0; i < list1.size(); i++){
            if(list1.get(i) != list2.get(i))
                return false;
        }
        return true;
    }
}
