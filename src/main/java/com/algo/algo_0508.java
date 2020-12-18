package com.algo;

import com.entity.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author yb
 * @date: 2020-12-18
 * 508. 出现次数最多的子树元素和
 */
public class algo_0508 {
    ArrayList<Integer> list = new ArrayList<>();
    int countMax = 1;
    HashMap<Integer, Integer> map = new HashMap<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        int[] res = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }
    private int dfs(TreeNode root){
        if (root == null)
            return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        update(left + right + root.val);
        return left + right + root.val;
    }
    private void update(int val){
        int count = map.getOrDefault(val, 0) + 1;
        map.put(val, count);
        if(count > countMax){
            countMax = count;
            list.clear();
            list.add(val);
        }else if(count == countMax){
            list.add(val);
        }
    }
}
