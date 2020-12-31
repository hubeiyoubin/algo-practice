package com.algo;

import com.entity.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : youbin
 * @date : 2020/12/31 23:05
 * 1161 最大层内元素和
 */
public class algo_1161 {

    /**
     * bfs
     * @param root
     * @return
     */
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


    /**
     *  dfs
     * @param root
     * @return
     */
    public int maxLevelSum_(TreeNode root) {
        dfs(root, 1);

        int maxIdx = 0;
        for (int i = 0; i < list.size(); ++i)
            maxIdx = list.get(i) > list.get(maxIdx) ? i : maxIdx;
        return maxIdx + 1;
    }

    List<Integer> list = new ArrayList<>();
    public void dfs(TreeNode node, int level) {
        if (node == null)
            return;
        if(list.size() < level){
            list.add(node.val);
        } else {
            list.set(level-1, list.get(level - 1) + node.val);
        }
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);

    }
}
