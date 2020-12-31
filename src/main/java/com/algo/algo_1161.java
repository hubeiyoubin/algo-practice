package com.algo;

import com.entity.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : youbin
 * @date : 2020/12/31 23:05
 * 1161 最大层内元素和
 */
public class algo_1161 {
    public int maxLevelSum(TreeNode root) {
        if(root == null)
            return 0;
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int max = Integer.MIN_VALUE;
        int depth = 0;
        int max_depth = 0;
        while(!q.isEmpty()){
            int size = q.size();
            int curSum = 0;
            depth ++;
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                curSum += node.val;
                if(node.left != null)
                    q.offer(node.left);
                if(node.right != null)
                    q.offer(node.right);
            }
            if(curSum > max){
                max = curSum;
                max_depth = depth;
            }
        }
        return max_depth;
    }
}
