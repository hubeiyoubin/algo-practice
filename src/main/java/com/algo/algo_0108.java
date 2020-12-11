package com.algo;

import com.entity.TreeNode;
//将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
//
// 示例:
//
// 给定有序数组: [-10,-3,0,5,9],
//
//一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
//
// Related Topics 树 深度优先搜索
/**
 * @author : youbin
 * @date : 2020/6/17 20:18
 * 108 将有序数组转换为二叉搜索树
 */
public class algo_0108 {
    int[] nums;

    public TreeNode helper(int left, int right) {
        if (left > right) return null;

        // always choose left middle node as a root
        int p = (left + right) / 2;

        // inorder traversal: left -> node -> right
        TreeNode root = new TreeNode(nums[p]);
        root.left = helper(left, p - 1);
        root.right = helper(p + 1, right);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return helper(0, nums.length - 1);
    }

    public TreeNode sortedArrayToBST2(int[] nums) {
        this.nums = nums;
        return toHelpBST(0, nums.length - 1);
    }

    private TreeNode toHelpBST(int left,  int right) {
        if(left > right)
            return null;
        int mid = (left + right) >>> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = toHelpBST(left,  mid - 1);
        root.right = toHelpBST(mid + 1,  right);
        return root;
    }

    public static void main(String[] args) {
        int a = 8;
        int b = 4;
        int c = 6;
        int d = 1;
        while(c-- > 0) {
            System.out.println((a + b) >> d ++ );
            System.out.println("c---"+c);
        }
    }

}
