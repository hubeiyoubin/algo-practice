package com.algo;

import com.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yb
 * @date: 2021-1-21
 * 1530 好叶子节点对的数量
 */
public class algo_1530 {
    int res;
    public int countPairs(TreeNode root, int distance) {
        if(root == null || distance <= 0)
            return 0;
        res = 0;
        dfs(root, distance);
        return res;
    }
    private List<Integer> dfs(TreeNode node, int distance){
        if(node == null)
            return new ArrayList<>();
        if(node.left == null && node.right == null){
            List<Integer> list = new ArrayList<>();
            list.add(1);
            return list;
        }
        List<Integer> cur = new ArrayList<>();
        List<Integer> left = dfs(node.left, distance);
        for(Integer l:left){
            ++l;
            if(l <= distance)
                cur.add(l);
        }
        List<Integer> right = dfs(node.right, distance);
        for(Integer r:right){
            ++r;
            if(r <= distance)
                cur.add(r);
        }
        for(Integer l:left){
            for(Integer r:right){
                if(l + r <= distance){
                    res +=1;
                }
            }
        }
        return cur;
    }
}
