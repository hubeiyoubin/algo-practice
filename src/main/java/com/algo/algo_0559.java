package com.algo;

import com.entity.Node;

import java.util.LinkedList;

/**
 * @author yb
 * @date: 2020-12-21
 * 559. N叉树的最大深度
 */
public class algo_0559 {

    // bfs
    public int maxDepth(Node root) {
        int level = 0;
        LinkedList<Node> que = new LinkedList<Node>();
        if(root != null)
            que.offer(root);
        while(!que.isEmpty()){
            int size = que.size();
            level ++;
            for(int i = 0; i < size; i ++){
                Node node = que.poll();
                for(Node child: node.children){
                    que.offer(child);
                }
            }

        }
        return level;
    }
}
