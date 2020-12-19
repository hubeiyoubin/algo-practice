package com.algo;

import com.entity.TreeNode;

import java.util.LinkedList;
//给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
//
//
// 二叉树的根是数组中的最大元素。
// 左子树是通过数组中最大值左边部分构造出的最大二叉树。
// 右子树是通过数组中最大值右边部分构造出的最大二叉树。
//
//
// 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
//
//
//
// 示例 ：
//
// 输入：[3,2,1,6,0,5]
//输出：返回下面这棵树的根节点：
//
//      6
//    /   \
//   3     5
//    \    /
//     2  0
//       \
//        1
//
//
//
//
// 提示：
//
//
// 给定的数组的大小在 [1, 1000] 之间。
/**
 * @author : youbin
 * @date : 2020/12/19 21:50
 * 654 最大二叉树
 */
public class algo_0654 {


    // 递归分治法
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums == null || nums.length == 0) {
            return null;
        }
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int l, int r){
        if(l > r)
            return null;
        if(l == r)
            return new TreeNode(nums[l]);

        int max_index = getMax(nums, l, r);
        TreeNode root = new TreeNode(nums[max_index]);
        root.left = dfs(nums, l, max_index - 1);
        root.right = dfs(nums, max_index + 1, r);
        return root;
    }

    private int getMax(int[] nums, int l, int r){
        int max = nums[l];
        int index = l;
        while(l < r){
            if(nums[l+1] > max){
                max = nums[l +1];
                index = l+1;
            }
            l ++;
        }
        return index;
    }

    // O(n)
    public TreeNode constructMaximumBinaryTree_02(int[] nums) {
        if(nums == null || nums.length == 0)
            return null;

        LinkedList<TreeNode> que = new LinkedList<>();
        for(int i = 0; i < nums.length; i ++){
            TreeNode cur = new TreeNode(nums[i]);
            while(!que.isEmpty() && que.peekFirst().val < nums[i]){
                cur.left = que.removeFirst();
            }
            if(!que.isEmpty()){
                que.peekFirst().right = cur;
            }
            que.addFirst(cur);
        }
        return que.peekLast();
    }


    // dfs O(nlogn)
    public TreeNode constructMaximumBinaryTree_(int[] nums) {
        if(nums == null || nums.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(nums[0]);
        for(int i = 1; i < nums.length; i++) {
            root = add(root, new TreeNode(nums[i]));
        }
        return root;
    }

    private TreeNode add(TreeNode root, TreeNode node) {
        if(root == null)
            return node;
        if(node == null)
            return root;

        if(node.val > root.val){
            node.left = root;
            return node;
        }
        root.right = add(root.right, node);
        return root;
    }
}
