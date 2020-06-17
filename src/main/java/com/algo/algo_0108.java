package com.algo;

import com.entity.TreeNode;

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
