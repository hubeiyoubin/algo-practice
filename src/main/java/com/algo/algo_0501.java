package com.algo;

import com.entity.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yb
 * @date: 2020-12-18
 */
public class algo_0501 {

    private List<Integer> keyList = new ArrayList<>();
    private int cur, count, max;
    public int[] findMode(TreeNode root) {
        max = 1;
        dfs(root);
        int[] res = new int[keyList.size()];
        for(int i=0; i < keyList.size(); i ++){
            res[i] = keyList.get(i);
        }
        return res;
    }

    // 中序遍历，从小到大，相同的数字在一起
    // [0,1,1,2,3,3]
    private void dfs(TreeNode root){
        if(root == null)
            return;
        dfs(root.left);
        update(root.val);
        dfs(root.right);
    }
    private void update(int val){
        if(val == cur) {
            count++;
            if(count == max){
                keyList.add(val);
            }else if(count > max){
                max = count;
                keyList.clear();
                keyList.add(val);
            }
        } else {
            cur = val;
            count = 1;
            if(count == max){
                keyList.add(val);
            }
        }
    }


    // 暴力解法，适用于任何二叉树
    public int[] findMode_(TreeNode root) {
        HashMap<Integer,Integer> map = new HashMap<>();
        dfs(root, map);
        List<Integer> keyList = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(entry.getValue() >= list.get(0)){
                list.clear();
                list.add(entry.getValue());
            }
        }
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(entry.getValue() == list.get(0)){
                keyList.add(entry.getKey());
            }
        }
        int[] res = new int[keyList.size()];
        for(int i=0; i < keyList.size(); i ++){
            res[i] = keyList.get(i);
        }
        return res;
    }

    private void dfs(TreeNode root, HashMap<Integer,Integer> map){
        if(root == null)
            return;
        map.put(root.val, map.getOrDefault(root.val,0) + 1);
        dfs(root.left, map);
        dfs(root.right, map);
    }

    // 第二种解法，// 暴力解法，适用于任何二叉树，优化
    private int max_2 = 0;
    public int[] findMode_2(TreeNode root) {
        HashMap<Integer,Integer> map = new HashMap<>();
        dfs_2(root, map);
        List<Integer> keyList = new ArrayList<>();

        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(entry.getValue() == max_2){
                keyList.add(entry.getKey());
            }
        }
        int[] res = new int[keyList.size()];
        for(int i=0; i < keyList.size(); i ++){
            res[i] = keyList.get(i);
        }
        return res;
    }

    private void dfs_2(TreeNode root, HashMap<Integer,Integer> map){
        if(root == null)
            return;
        map.put(root.val, map.getOrDefault(root.val,0) + 1);
        max_2 = Math.max(map.getOrDefault(root.val,0), max_2);
        dfs_2(root.left, map);
        dfs_2(root.right, map);
    }
}
