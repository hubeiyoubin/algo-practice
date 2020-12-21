package com.algo;

import com.entity.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : youbin
 * @date : 2020/12/19 14:39
 * 652 寻找重复的子树
 */
public class algo_0652 {


    int t;
    Map<String, Integer> trees;
    Map<Integer, Integer> count;
    List<TreeNode> ans;
    // 字符串拼接优化
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        t = 1;
        trees = new HashMap();
        count = new HashMap();
        ans = new ArrayList();
        lookup(root);
        return ans;
    }
    // 每个非空节点值 +1，并向上累加, 保证以下三元组的唯一性，不用像下面方法获取此节点的整棵树
    //一个节点 node 的左孩子 id 为 x，右孩子 id 为 y，那么该节点的 id 为 (node.val, x, y)。
    public int lookup(TreeNode node) {
        if (node == null) return 0;
        String serial = node.val + "," + lookup(node.left) + "," + lookup(node.right);
        int uid = trees.computeIfAbsent(serial, x-> t++);
        count.put(uid, count.getOrDefault(uid, 0) + 1);
        if (count.get(uid) == 2)
            ans.add(node);
        return uid;
    }




    HashMap<String,Integer> map = new HashMap<>();
    List<TreeNode> list = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees_(TreeNode root) {
        if(root == null)
            return null;

        dfs(root);
        return list;
    }

    private String dfs(TreeNode root){
        if(root == null)
            return "#";
        String tree = root.val + ","+ dfs(root.left)+ "," + dfs(root.right);
        //System.out.println(tree);
        map.put(tree, map.getOrDefault(tree, 0) + 1);
        if(map.getOrDefault(tree, 0) == 2)
            list.add(root);

        return tree;
    }
}
