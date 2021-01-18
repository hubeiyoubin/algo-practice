package com.algo;

import com.entity.ListNode;
import com.entity.TreeNode;

/**
 * @author yb
 * @date: 2021-1-18
 * 1367 二叉树中的列表
 */
public class algo_1367 {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(root == null && head == null)
            return true;
        if(root == null || head == null)
            return false;
        return dfs(root, head) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean dfs(TreeNode root, ListNode head){
        if(head == null){
            return true;
        }
        if(root == null){
            return false;
        }

        if(root.val != head.val)
            return false;

        return dfs(root.left,head.next) || dfs(root.right,head.next);
    }
}
