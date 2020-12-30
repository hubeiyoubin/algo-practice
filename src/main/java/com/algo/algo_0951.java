package com.algo;

import com.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yb
 * @date: 2020-12-30
 * 951 翻转等价二叉树
 */
public class algo_0951 {
    //标准态遍历, 先小 后大
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null)
            return true;
        if(root1 == null || root2 == null)
            return false;

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        dfs(root1, list1);
        dfs(root2, list2);
        return list1.equals(list2);
    }
    private void dfs(TreeNode root, List<Integer> list){
        if(root == null)
            return;
        list.add(root.val);
        int left = root.left == null ? -1 : root.left.val;
        int right = root.right == null ? -1 : root.right.val;
        if(left < right){
            dfs(root.left, list);
            dfs(root.right, list);
        }else{
            dfs(root.right, list);
            dfs(root.left, list);
        }
    }

    /**
     * dfs_ 翻转
     * @param root1
     * @param root2
     * @return
     */
    public boolean flipEquiv_(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null)
            return true;
        if(root1 == null || root2 == null)
            return false;

        return dfs_(root1, root2);
    }
    private boolean dfs_(TreeNode root1, TreeNode root2){
        if(root1 == root2)
            return true;
        if(root1 == null || root2 == null || root1.val != root2.val)
            return false;

        return dfs_(root1.left,root2.left) && dfs_(root1.right,root2.right)
                || (dfs_(root1.left,root2.right) && dfs_(root1.right,root2.left));
    }
}
