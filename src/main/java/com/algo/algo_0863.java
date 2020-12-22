package com.algo;

import com.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
//给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。
//
// 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
//
//
//
//
//
//
// 示例 1：
//
// 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
//输出：[7,4,1]
//解释：
//所求结点为与目标结点（值为 5）距离为 2 的结点，
//值分别为 7，4，以及 1
//
//
//
//注意，输入的 "root" 和 "target" 实际上是树上的结点。
//上面的输入仅仅是对这些对象进行了序列化描述。
//
//
//
//
// 提示：
//
//
// 给定的树是非空的。
// 树上的每个结点都具有唯一的值 0 <= node.val <= 500 。
// 目标结点 target 是树上的结点。
// 0 <= K <= 1000.
//
// Related Topics 树 深度优先搜索 广度优先搜索
/**
 * @author yb
 * @date: 2020-12-22
 * 863 二叉树中所有距离为 K 的结点
 */
public class algo_0863 {

    List<Integer> list;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        list = new ArrayList<>();
        dfs(root, target, K);
        return list;
    }
    private int dfs(TreeNode root, TreeNode target, int K){
        if(root == null)
            return -1;
        else if(root == target) {
            addNode(root, 0,  K);
            return 1;
        } else {
            int left = dfs(root.left, target, K);
            int right = dfs(root.right, target, K);
            if (left != -1) {
                if(left == K){
                    list.add(root.val);
                }
                addNode(root.right, left + 1, K);
                return left + 1;
            } else if (right != -1){
                if(right == K){
                    list.add(root.val);
                }
                addNode(root.left, right + 1, K);
                return right +1;
            } else {
                return -1;
            }
        }
    }

    private void addNode(TreeNode node, int d, int K){
        if(node == null)
            return;
        if(K - d == 0){
            list.add(node.val);
        } else {
            addNode(node.left, d + 1, K);
            addNode(node.right, d + 1, K);
        }
    }
}
