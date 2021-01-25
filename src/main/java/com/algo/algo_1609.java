package com.algo;

import com.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yb
 * @date: 2021-1-22
 * 1609 奇偶树
 */
public class algo_1609 {
    public boolean isEvenOddTree(TreeNode root) {
        if(root == null)
            return false;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int level = 0;
        while(!que.isEmpty()){
            int size = que.size();
            LinkedList<Integer> list = new LinkedList<>();
            list.addLast(que.peek().val);
            for(int i=0; i < size; i++){
                TreeNode node = que.poll();
                if(level%2 != 0 && node.val % 2 != 0)
                    return false;
                if(level%2 == 0 && node.val % 2 == 0)
                    return false;
                if(i > 0){
                    int pre = list.peekLast();
                    if(level%2==0 && pre >= node.val)
                        return false;
                    if(level%2!=0 && pre <= node.val)
                        return false;
                    list.addLast(node.val);
                }
                if(node.left != null)
                    que.offer(node.left);
                if(node.right != null)
                    que.offer(node.right);
            }
            level ++;
        }
        return true;
    }
}
