package com.algo;

import com.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yb
 * @date: 2020-12-18
 */
public class algo_0513 {
    // bfs
    public int findBottomLeftValue(TreeNode root) {
        if(root == null)
            return -1;
        int cur = -1;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()){
            int size = que.size();
            for(int i = 0; i < size; i++){
                TreeNode node = que.poll();
                if(node.left != null)
                    que.offer(node.left);
                if(node.right != null)
                    que.offer(node.right);
                if(i == 0)
                    cur = node.val;
            }
        }
        return cur;
    }


    // dfs
    int cur, level;
    public int findBottomLeftValue_(TreeNode root) {
        if(root == null)
            return -1;
        cur = root.val;
        dfs(root, 0);
        return cur;
    }
    private void dfs(TreeNode root, int depth){
        if(root == null)
            return;
        if(depth > level){
            cur = root.val;
            level ++;
        }
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}
