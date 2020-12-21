package com.algo;

import com.entity.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yb
 * @date: 2020-12-21
 * 429. N 叉树的层序遍历
 */
public class algo_0429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        LinkedList<Node> que = new LinkedList<Node>();
        if(root != null)
            que.offer(root);
        while(!que.isEmpty()){
            int size = que.size();
            List<Integer> inList = new ArrayList<>();
            for(int i = 0; i < size; i ++){
                Node node = que.poll();
                inList.add(node.val);
                for(Node child: node.children){
                    que.offer(child);
                }
            }
            list.add(inList);
        }
        return list;
    }
}
