package com.algo;
//根据一棵树的中序遍历与后序遍历构造二叉树。
//
// 注意:
//你可以假设树中没有重复的元素。
//
// 例如，给出
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3]
//
// 返回如下的二叉树：
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// Related Topics 树 深度优先搜索 数组

import com.entity.TreeNode;

import java.util.HashMap;

/**
 * @author yb
 * @date: 2020-12-10
 * 106.从中序与后序遍历序列构造二叉树
 */
public class algo_0106 {

    /*后序遍历的形式总是
        [ [左子树的前序遍历结果], [右子树的前序遍历结果], 根节点]
  而中序遍历的形式总是
        [ [左子树的中序遍历结果], 根节点, [右子树的中序遍历结果] ]*/

    private HashMap<Integer,Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0 || postorder.length == 0)
            return null;

        map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }

        return buildTwoTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTwoTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if(inStart > inEnd || postStart > postEnd)
            return null;

        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        int inRootIndex = map.get(rootVal);
        int leftTreeCount = inRootIndex - inStart;

        root.left = buildTwoTree(inorder, inStart, inRootIndex - 1, postorder, postStart, postStart + leftTreeCount - 1);
        root.right = buildTwoTree(inorder, inRootIndex + 1, inEnd, postorder, postStart + leftTreeCount ,postEnd - 1);
        return root;
    }
}
