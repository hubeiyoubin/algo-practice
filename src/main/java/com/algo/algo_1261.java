package com.algo;

import com.entity.TreeNode;

import java.util.HashSet;

/**
 * @author yb
 * @date: 2021-1-14
 * 1261 在受污染的二叉树中查找元素
 */
public class algo_1261 {

    class FindElements {

        private TreeNode root;
        private HashSet<Integer> set;
        public FindElements(TreeNode root) {
            set = new HashSet();
            dfs(root, 0);
            this.root = root;
        }
        private void dfs(TreeNode root, int pval){
            if(root == null)
                return;
            root.val = pval;
            set.add(root.val);
            dfs(root.left, root.val * 2 + 1);
            dfs(root.right, root.val * 2 + 2);
        }

        public boolean find(int target) {
            return set.contains(Integer.valueOf(target));
        }
    }

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
}
