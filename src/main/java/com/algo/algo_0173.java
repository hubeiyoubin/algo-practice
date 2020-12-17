package com.algo;

import com.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
//实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
//
// 调用 next() 将返回二叉搜索树中的下一个最小的数。
/**
 * @author yb
 * @date: 2020-12-17
 */
public class algo_0173 {


    // 先将树的左节点放到stack中，取出时，再将右节点的左节点放入
    // 即中序遍历和迭代同时进行处理
    class BSTIterator {


       Stack<TreeNode> stack = new Stack<>();
        public BSTIterator(TreeNode root) {
           pushStack(root);
        }

        private void pushStack(TreeNode root) {
            if(root == null)
                return;
            while(root != null){
                stack.push(root);
                root = root.left;
            }
        }


        public int next() {
            TreeNode left = stack.pop();
            if(left.right != null){
                pushStack(left.right);
            }
            return left.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }

    // 先中序遍历，储存结果在list中，再逐个获取
    class BSTIterator_02 {

        List<Integer> list = new ArrayList<>();
        int index = 0;
        public BSTIterator_02(TreeNode root) {
            inorder(root);
        }

        private void inorder(TreeNode root) {
            if(root == null)
                return;
            inorder(root.left);
            list.add(root.val);
            inorder(root.right);
        }

        public int next() {
            return list.get(index++);
        }

        public boolean hasNext() {
            return index < list.size();
        }
    }
}
