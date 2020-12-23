package com.algo;

import com.entity.TreeNode;

import java.util.*;

/**
 * @author yb
 * @date: 2020-12-22
 * 872 叶子相似的树
 */
public class algo_0872 {

    // 递归法 dfs
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(root1 == null || root2 == null)
            return root1 == null && root2 == null;

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        dfs(root1, list1);
        dfs(root2, list2);
        if(list1.size() != list2.size())
            return false;
        for(int i=0; i < list1.size(); i++){
            if(list1.get(i) != list2.get(i))
                return false;
        }
        return true;
    }
    private void dfs(TreeNode root, List<Integer> list){
        if(root == null)
            return;
        if(root.left == null && root.right == null){
            list.add(root.val);
            return;
        }
        dfs(root.left, list);
        dfs(root.right, list);
    }


    // 迭代法，以前序遍历，储存叶子节点，并进行比较
    public boolean leafSimilar_(TreeNode root1, TreeNode root2) {
        if(root1 == null || root2 == null)
            return root1 == null && root2 == null;

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root1);
        s2.push(root2);

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        while(!s1.isEmpty()){
            TreeNode node = s1.pop();
            if(node.left == null && node.right == null)
                list1.add(node.val);
            if(node.right != null)
                s1.push(node.right);
            if(node.left != null)
                s1.push(node.left);
        }
        while(!s2.isEmpty()){
            TreeNode node = s2.pop();
            if(node.left == null && node.right == null)
                list2.add(node.val);
            if(node.right != null)
                s2.push(node.right);
            if(node.left != null)
                s2.push(node.left);
        }
        if(list1.size() != list2.size())
            return false;
        for(int i=0; i < list1.size(); i++){
            if(list1.get(i) != list2.get(i))
                return false;
        }
        return true;
    }
}
