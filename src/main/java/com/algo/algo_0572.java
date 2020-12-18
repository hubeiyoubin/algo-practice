package com.algo;

import com.entity.TreeNode;

/**
 * @author yb
 * @date: 2020-12-18
 * 572.另一个树的子树
 */
public class algo_0572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return findSame(s, t);
    }

    private boolean findSame(TreeNode s, TreeNode t){
        if(s == null)
            return false;

        boolean left_ = findSame(s.left,t);
        boolean right_ = findSame(s.right,t);
        return check(s, t) ||  left_ || right_;

    }
    public boolean check(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null || s.val != t.val) {
            return false;
        }
        return check(s.left, t.left) && check(s.right, t.right);
    }
}
