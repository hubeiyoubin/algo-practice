package com.algo;

import com.entity.TreeNode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author yb
 * @date: 2020-12-31
 * 987 二叉树的垂序遍历
 */
public class algo_0987 {

    class Location implements Comparable<Location>{
        int x;
        int y;
        int val;
        Location(int x, int y, int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Location lo) {
            if(this.x != lo.x){
                return Integer.compare(this.x, lo.x);
            } else if(this.y != lo.y){
                return - Integer.compare(this.y, lo.y);
            } else {
                return Integer.compare(this.val, lo.val);
            }
        }
    }

    List<Location> locations;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        locations = new ArrayList<>();
        dfs(root, 0, 0);
        Collections.sort(locations);
        List<List<Integer>> list = new ArrayList<>();
        if(locations != null && locations.size() > 0){
            int pre= locations.get(0).x;
            int i = 0;
            list.add(new ArrayList<>());
            while(i < locations.size()){
                Location cur = locations.get(i);
                if(cur.x != pre){
                    pre = cur.x;
                    list.add(new ArrayList<>());
                }
                list.get(list.size() - 1).add(cur.val);
                i ++;
            }
        }
        return list;
    }

    private void dfs(TreeNode root, int x, int y) {
        if(root == null)
            return;
        locations.add(new Location(x, y, root.val));
        dfs(root.left, x - 1, y -1);
        dfs(root.right, x + 1, y -1);
    }

}
