package com.algo;

import com.entity.TreeNode;

import java.util.LinkedList;
//序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
//
// 设计一个算法来序列化和反序列化 二叉搜索树 。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序
//列化为最初的二叉搜索树。
//
// 编码的字符串应尽可能紧凑。
//
//
//
// 示例 1：
//
//
//输入：root = [2,1,3]
//输出：[2,1,3]
//
//
// 示例 2：
//
//
//输入：root = []
//输出：[]
//
//
//
//
// 提示：
//
//
// 树中节点数范围是 [0, 104]
// 0 <= Node.val <= 104
// 题目数据 保证 输入的树是一棵二叉搜索树。
//
//
//
//
// 注意：不要使用类成员/全局/静态变量来存储状态。 你的序列化和反序列化算法应该是无状态的。
// Related Topics 树
/**
 * @author yb
 * @date: 2020-12-18
 * 449. 序列化和反序列化二叉搜索树
 */
public class algo_0449 {
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            dfs(root, sb);
            if (sb.length() > 0)
                sb.deleteCharAt(sb.length() - 1);

            System.out.println(sb.toString());
            return sb.toString();
        }
        private void dfs(TreeNode root, StringBuilder sb){
            if(root == null)
                return;
            sb.append(root.val+",");
            dfs(root.left, sb);
            dfs(root.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(data == null || data.length() == 0)
                return null;
            LinkedList<Integer> list = new LinkedList<>();
            for(String str : data.split(",")){
                list.addLast(Integer.valueOf(str));
            }
            return deserialize(Integer.MAX_VALUE, Integer.MIN_VALUE, list);
        }
        private TreeNode deserialize(int max, int min, LinkedList<Integer> list){
            if(list.isEmpty())
                return null;
            int val = list.getFirst();
            if (val < min || val > max)
                return null;

            TreeNode root = new TreeNode(list.removeFirst());
            root.left = deserialize(val, min, list);
            root.right = deserialize(max, val, list);
            return root;
        }
    }
}
