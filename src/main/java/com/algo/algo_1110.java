package com.algo;

import com.entity.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author : youbin
 * @date : 2021/1/1 0:33
 * 1110 删点成林
 */
public class algo_1110 {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        // 为了快速判断节点是否要被删除，使用HashSet加快查找
        Set<Integer> deleteSet = new HashSet<>();
        for (int x : to_delete) deleteSet.add(x);

        // 给根节点伪造一个父节点
        TreeNode fakeRoot = new TreeNode(0);
        fakeRoot.left = root;

        List<TreeNode> ans = new ArrayList<>();
        foo(ans, fakeRoot, root, deleteSet);
        // 如果根节点还在，别忘记加入根节点
        if (fakeRoot.left != null) ans.add(root);

        return ans;
    }

    // 使用后续遍历方式删除节点，这样不会影响子树的删除
    private void foo(List<TreeNode> ans, TreeNode parent, TreeNode root, Set<Integer> deleteSet) {
        if (root == null) return;
        if (root.left != null) foo(ans, root, root.left, deleteSet);
        if (root.right != null) foo(ans, root, root.right, deleteSet);
        // 如果根节点要删除
        if (deleteSet.contains(root.val)) {
            if (root.left != null) ans.add(root.left);
            if (root.right != null) ans.add(root.right);
            // 断掉父节点与本节点的连接
            if (parent.left == root) parent.left = null;
            else parent.right = null;
        }
    }
}
