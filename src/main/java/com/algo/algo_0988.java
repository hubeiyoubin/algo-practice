package com.algo;

import com.entity.TreeNode;

/**
 * @author yb
 * @date: 2020-12-31
 * 988 从叶结点开始的最小字符串
 */
public class algo_0988 {
    String ans = "~";
    public String smallestFromLeaf(TreeNode root) {

        dfs(root, new StringBuffer());
        return ans;
    }
    private void dfs(TreeNode root, StringBuffer sb){
        if(root == null)
            return;
        if(root.left == null && root.right == null){
            sb.append((char)('a'+root.val));
            sb.reverse();
            String str = sb.toString();
            if (str.compareTo(ans) < 0)
                ans = str;
            return;
        }
        sb.append((char)('a'+root.val));
        dfs(root.left, new StringBuffer(sb));
        dfs(root.right, new StringBuffer(sb));
    }
}
