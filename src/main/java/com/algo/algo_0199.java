package com.algo;
//给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
//
// 示例:
//
// 输入: [1,2,3,null,5,null,4]
//输出: [1, 3, 4]
//解释:
//
//   1            <---
// /   \
//2     3         <---
// \     \
//  5     4       <---
//

import com.entity.TreeNode;

import java.util.*;

/**
 * @author yb
 * @date: 2020-12-17
 */
public class algo_0199 {

    // bfs
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        if(root != null)
            que.offer(root);
        while(!que.isEmpty()){
            int size = que.size();
            for(int i=0; i<size; i++){
                TreeNode node = que.poll();
                if(node.left != null)
                    que.offer(node.left);

                if(node.right != null)
                    que.offer(node.right);
                if(i == size - 1)
                    list.add(node.val);
            }

        }
        return list;
    }

    // dfs
    public List<Integer> rightSideView_02(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root,0, list);
        return list;
    }

    private void dfs(TreeNode root, int depth, List<Integer> list) {
        if(root == null)
            return;

        if(list.size() == depth){
            list.add(root.val);
        }
        depth ++ ;
        dfs(root.right, depth, list);
        dfs(root.left, depth, list);
    }
}
