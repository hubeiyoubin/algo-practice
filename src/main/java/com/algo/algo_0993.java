package com.algo;

import com.entity.TreeNode;

/**
 * @author yb
 * @date: 2020-12-31
 * 993 二叉树的堂兄弟节点
 */
public class algo_0993 {
    int xh;
    int yh;
    int xp;
    int yp;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, x, y, 0);
        return xh == yh && xp != yp;
    }
    private void dfs(TreeNode root, int x, int y, int depth){
        if(root == null)
            return;
        dfs(root.left,x,y,depth+1);
        dfs(root.right,x,y, depth+1);
        if((root.left != null && root.left.val == x)
                || (root.right != null && root.right.val == x)){
            xh = depth+1;
            xp = root.val;
        }
        if((root.left != null && root.left.val == y)
                || (root.right != null && root.right.val == y)){
            yh = depth+1;
            yp = root.val;
        }
    }
}
