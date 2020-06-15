package com.algo;

/**
 * @author yb
 * @date: 2020-6-15
 * 100. 相同的树
 */
public class algo_0100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;
        if(p == null || q == null)
            return false;
        if(p.val != q.val)
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if(p != null && q == null)
            return false;
        if(p == null && q != null)
            return false;
        if(p != null && q != null && p.val != q.val)
            return false;
        if(p != null && q != null) {
            boolean isSameLeft = isSameTree2(p.left, q.left);
            if (!isSameLeft)
                return false;

            boolean isSameRight = isSameTree2(p.right, q.right);
            if (!isSameRight)
                return false;
        }
        return true;
    }

    private class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
