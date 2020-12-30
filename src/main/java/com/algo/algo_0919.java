package com.algo;

import com.entity.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yb
 * @date: 2020-12-30
 * 919 完全二叉树插入器
 */
public class algo_0919 {
    class CBTInserter {
        TreeNode root;
        Deque<TreeNode> deque;
        public CBTInserter(TreeNode root) {
            this.root = root;
            Queue<TreeNode> queue = new LinkedList<>();
            deque = new LinkedList<>();
            if(root != null)
                queue.offer(root);
            while(!queue.isEmpty()){
                TreeNode node = queue.poll();
                if(node.left == null || node.right == null)
                    deque.offer(node);
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
            }
        }

        public int insert(int v) {
            if(this.root == null){
                this.root = new TreeNode(v);
                return -1;
            }
            TreeNode node = deque.peekFirst();
            deque.offer(new TreeNode(v));
            if(node.left == null) {
                node.left = deque.peekLast();
            }else if(node.right == null){
                node.right = deque.peekLast();
                deque.pollFirst();
            }
            return node.val;
        }


        public TreeNode get_root() {
            return this.root;
        }
    }

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(v);
 * TreeNode param_2 = obj.get_root();
 */
}
