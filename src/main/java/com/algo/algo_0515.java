package com.algo;

import com.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yb
 * @date: 2020-12-18
 * 515. 在每个树行中找最大值
 */
public class algo_0515 {

    // bfs
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> que = new LinkedList<TreeNode>();
        if(root != null)
            que.offer(root);
        while(!que.isEmpty()){
            int size = que.size();
            int max = que.peek().val;
            for(int i=0; i<size; i++){
                TreeNode node = que.poll();
                if(node.left != null)
                    que.offer(node.left);
                if(node.right != null)
                    que.offer(node.right);
                if(node.val > max)
                    max = node.val;
            }
            list.add(max);
        }
        return list;
    }



    // dfs 解法
    public List<Integer> largestValues_(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, 0, list);
        return list;
    }
    private void dfs(TreeNode root, int depth, List<Integer> list){
        if(root == null)
            return;
        if(list.size() <= depth){
            list.add(root.val);
        }else if(root.val > list.get(depth)){
            list.set(depth, root.val);
        }
        dfs(root.left, depth + 1, list);
        dfs(root.right, depth + 1, list);
    }
}
