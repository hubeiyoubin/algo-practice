package com.algo;


//给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
//
// 例如：
//给定二叉树 [3,9,20,null,null,15,7],
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回锯齿形层次遍历如下：
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
//
// Related Topics 栈 树 广度优先搜索
// 👍 304 👎 0

import com.entity.TreeNode;

import java.util.*;

/**
 * @author yb
 * @date: 2020-12-10
 *
 * 103.二叉树的锯齿形层次遍历
 */
public class algo_0103 {

    // dfs
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        dfs(root, 0, lists);
        return lists;
    }

    private void dfs(TreeNode node, int depth, List<List<Integer>> lists) {
        if(node == null)
            return;

        if(lists.size() < depth + 1){
            LinkedList<Integer> nums = new LinkedList<>();
            nums.add(node.val);
            lists.add(nums);
        }else{
            if((depth & 1) == 0)
                lists.get(depth).add(node.val);
            else
                lists.get(depth).add(0, node.val);
        }
        dfs(node.left, depth + 1, lists);
        dfs(node.right, depth +1, lists);
    }

    // bfs
    public List<List<Integer>> zigzagLevelOrder_02(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null)
            queue.offer(root);

        int depth = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            LinkedList<Integer> nums = new LinkedList<>();
            for(int i = 0; i < size; i ++){
                TreeNode node = queue.poll();
                if(node.left != null)
                    queue.offer(node.left);

                if(node.right != null)
                    queue.offer(node.right);

                if((depth & 1) == 0){
                    nums.addLast(node.val);
                }else{
                    nums.addFirst(node.val);
                }
            }
            lists.add(nums);
            depth ++;
        }
        return lists;
    }
}
