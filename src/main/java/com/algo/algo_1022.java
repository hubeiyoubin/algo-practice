package com.algo;

import com.entity.TreeNode;

/**
 * @author yb
 * @date: 2020-12-31
 * 1022 从根到叶的二进制数之和
 */
public class algo_1022 {

    /**
     *  从上往下累加
     * @param root
     * @return
     */
    public int sumRootToLeaf(TreeNode root) {
        dfs(root, 0);
        return sum;
    }
    private void dfs(TreeNode root, int cur){
        if(root == null)
            return;

        if(root.left == null && root.right == null){
            sum = sum + cur * 2 + root.val;
            return;
        }
        dfs(root.left, cur * 2 + root.val);
        dfs(root.right, cur * 2 + root.val);
    }


    int sum;
    public int sumRootToLeaf_(TreeNode root) {
        dfs(root, new StringBuilder());
        return sum;
    }

    /**
     *         执行耗时:10 ms,击败了8.90% 的Java用户
     * 			内存消耗:37.7 MB,击败了85.36% 的Java用户
     *
     * @param root
     * @param sb
     */
    private void dfs(TreeNode root, StringBuilder sb){
        if(root == null){
            return;
        }
        sb.append(root.val);
        if(root.left == null && root.right == null) {
            System.out.println(sb);
            int count = Integer.parseInt(sb.toString(), 2);
            sum = sum + count;
            //return;
        }
        // 此处比起 下面方法更节约内存
        dfs(root.left, sb);
        dfs(root.right,sb);
        sb.deleteCharAt(sb.length() - 1);
    }

    /**
     *  	执行耗时:12 ms,击败了7.78% 的Java用户
     * 		内存消耗:38.2 MB,击败了28.29% 的Java用户
     * @param root
     * @param sb
     */
    private void dfs_(TreeNode root, StringBuilder sb){
        if(root == null){
            return;
        }
        sb.append(root.val);
        if(root.left == null && root.right == null) {
            System.out.println(sb);
            int count = Integer.parseInt(sb.toString(), 2);
            sum = sum + count;
            return;
        }
        dfs_(root.left, new StringBuilder(sb));
        dfs_(root.right,new StringBuilder(sb));
    }
}
