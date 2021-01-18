package com.algo;

import com.entity.TreeNode;

/**
 * @author yb
 * @date: 2021-1-18
 * 1379 找出克隆二叉树中的相同节点
 */
public class algo_1379 {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(original == null || cloned == null)
            return null;
        if(cloned.val == target.val)
            return cloned;
        TreeNode left = getTargetCopy(original.left,cloned.left,target);
        return left != null ? left : getTargetCopy(original.right,cloned.right, target);
    }
}
