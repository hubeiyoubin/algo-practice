package com.algo;

/**
 * @author yb
 * @date: 2020-12-8
 */
//给你二叉搜索树的根节点 root ，该树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。
//
// 进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用常数空间的解决方案吗？
//
//
//
// 示例 1：
//
//
//输入：root = [1,3,null,null,2]
//输出：[3,1,null,null,2]
//解释：3 不能是 1 左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
//
//
// 示例 2：
//
//
//输入：root = [3,1,4,null,null,2]
//输出：[2,1,4,null,null,3]
//解释：2 不能在 3 的右子树中，因为 2 < 3 。交换 2 和 3 使二叉搜索树有效。
//
//
//
// 提示：
//
//
// 树上节点的数目在范围 [2, 1000] 内
// -231 <= Node.val <= 231 - 1
//
// Related Topics 树 深度优先搜索
// 👍 376 👎 0


import com.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *  99. 恢复二叉搜索树
  */
public class algo_0099 {

    private TreeNode x;
    private TreeNode y;
    private TreeNode pre;
    public void recoverTree(TreeNode root) {
        dfs(root);
        if(x!=null && y!=null) {
            int tmp = x.val;
            x.val = y.val;
            y.val = tmp;
        }
    }

    private void dfs(TreeNode node) {
        if(node==null) {
            return;
        }
        dfs(node.left);
        if (pre != null) {
            if (pre.val > node.val) {
                y = node;
                if (x == null) {
                    x = pre;
                }
            }
        }
        pre = node;
        dfs(node.right);
    }


    public void recoverTree_03(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        dfs_03(root, list);
        TreeNode x = null;
        TreeNode y = null;
        //扫面遍历的结果，找出可能存在错误交换的节点x和y
        for(int i = 0; i < list.size() - 1; i ++){
            if(list.get(i).val > list.get(i + 1).val){
                y = list.get(i + 1);
                if(x == null){
                    x = list.get(i);
                }else{
                    break;
                }
            }
        }
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
        //如果x和y不为空，则交换这两个节点值，恢复二叉搜索树s
    }

    private void dfs_03(TreeNode root, List<TreeNode> list) {
        if(root == null)
            return;

        dfs_03(root.left, list);
        list.add(root);
        dfs_03(root.right, list);
    }

    public void recoverTree_02(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs_02(root, list);
        int[] swapped = findTwoSwapped(list);
        recover(root, 2, swapped[0],swapped[1]);
    }

    private void recover(TreeNode root, int count, int x, int y) {
        if (root != null) {
            if (root.val == x || root.val == y) {
                root.val = root.val == x ? y : x;
                if (--count == 0) {
                    return;
                }
            }
            recover(root.right, count, x, y);
            recover(root.left, count, x, y);
        }
    }

    private int[] findTwoSwapped(List<Integer> list) {
        int x = -1;
        int y = -1;
        for(int i = 0; i < list.size() - 1; i ++){
            if(list.get(i) > list.get(i+1)){
                y = list.get(i+1);
                if (x == -1) {
                    x = list.get(i);
                }else{
                    break;
                }
            }
        }
        return new int[]{x,y};
    }

    private void dfs_02(TreeNode node, List<Integer> list) {
        if(node == null)
            return;

        dfs_02(node.left, list);
        list.add(node.val);
        dfs_02(node.right, list);
    }


}
