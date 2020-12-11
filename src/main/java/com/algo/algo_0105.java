package com.algo;

//根据一棵树的前序遍历与中序遍历构造二叉树。
//
// 注意:
//你可以假设树中没有重复的元素。
//
// 例如，给出
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7]
//
// 返回如下的二叉树：
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// Related Topics 树 深度优先搜索 数组

import com.entity.TreeNode;

import java.util.HashMap;

/**
 * @author yb
 * @date: 2020-12-10
 * 105.从前序与中序遍历序列构造二叉树
 */
public class algo_0105 {
    private HashMap<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0)
            return null;
        map = new HashMap<>();
        for(int i=0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return buildTwoTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTwoTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if(preStart > preEnd){
            return null;
        }
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int in_root = map.get(rootVal);
        int size_left_subtree = in_root - inStart;
        root.left = buildTwoTree(preorder, preStart + 1, preStart +size_left_subtree, inorder, inStart, in_root - 1);
        root.right = buildTwoTree(preorder, preStart +size_left_subtree + 1, preEnd, inorder, in_root + 1, inEnd);
        return root;
    }
}

/*前序遍历的形式总是
        [ 根节点, [左子树的前序遍历结果], [右子树的前序遍历结果] ]
  而中序遍历的形式总是
        [ [左子树的中序遍历结果], 根节点, [右子树的中序遍历结果] ]*/
