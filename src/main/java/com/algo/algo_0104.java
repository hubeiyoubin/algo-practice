package com.algo;

import com.entity.TreeNode;
import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author : youbin
 * @date : 2020/6/15 21:07
 */
public class algo_0104 {
    public static int maxDepth(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        if(root != null){
            queue.add(new Pair(root, 1));
        }
        int depth = 0;
        while(!queue.isEmpty()){
            Pair<TreeNode, Integer> current = queue.poll();
            root = current.getKey();
            int curDepth = current.getValue();
            System.out.println("curDepth: "+curDepth);
            if(root != null){
                depth = Math.max(curDepth, depth);
                queue.add(new Pair(root.left, curDepth + 1));
                queue.add(new Pair(root.right, curDepth + 1));
            }
        }
        System.out.println(depth);
        return depth;
    }

    public int maxDepth2(TreeNode root) {
        if(root  == null)
            return  0;

        int leftDepth = maxDepth2(root.left);
        int rightDepth = maxDepth2(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        Integer[] arr = {3,9,20,null,null,15,7};
        TreeNode root = TreeNode.constructTree(arr);
        maxDepth(root);
    }

}
