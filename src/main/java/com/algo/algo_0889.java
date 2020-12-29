package com.algo;

import com.entity.TreeNode;

import java.util.HashMap;

/**
 * @author yb
 * @date: 2020-12-29
 * 889 根据前序和后序遍历构造二叉树
 */
public class algo_0889 {
    HashMap<Integer, Integer> map;
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if(pre == null || post == null || pre.length == 0 || post.length == 0)
            return null;
        map = new HashMap<>();
        for(int i=0; i < post.length; i++){
            map.put(post[i], i);
        }
        return dfs(pre,  0, pre.length - 1, 0, post.length-1);
    }

    private TreeNode dfs(int[] pre, int pre_start, int pre_end, int post_start, int post_end){
        if(pre_start > pre_end)
            return null;
        if(pre_start == pre_end)
            return new TreeNode(pre[pre_start]);

        TreeNode root = new TreeNode(pre[pre_start]);
        int left_end = map.get(pre[pre_start + 1]);
        int location = left_end - post_start;
        root.left = dfs(pre,  pre_start+1,pre_start+location+1,post_start, post_start + location);
        root.right = dfs(pre,pre_start+location+2,pre_end,post_start+location + 1, post_end - 1);
        return root;
    }
}
