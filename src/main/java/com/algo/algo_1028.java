package com.algo;

import com.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yb
 * @date: 2020-12-31
 * 1028 从先序遍历还原二叉树
 */
public class algo_1028 {

    /**
     *  记录节点值和节点深度值
     */
    List<Integer> valList = new ArrayList<>();
    List<Integer> depthList = new ArrayList<>();
    public TreeNode recoverFromPreorder(String S) {
        if(S == null || S.length() == 0)
            return null;
        int count = 0;
        int sum = 0;
        int preCount = -1;
        int preSum = -1;
        for(int i=0; i<S.length(); i++){
            if(S.charAt(i) != '-') {
                sum = sum * 10 + (S.charAt(i) - '0');
                if(preCount != count) {
                    depthList.add(count);
                    count = 0;
                    preCount = count;
                }
                if(S.length() - 1 == i){
                    valList.add(sum);
                }
            } else {
                if(preSum != sum) {
                    valList.add(sum);
                    sum = 0;
                    preSum = sum;
                }
                count ++;
            }
        }

        for(int i=0; i < valList.size(); i++){
            System.out.println(valList.get(i));
        }
        return dfs(0,valList.size()-1, 0);
    }
    private TreeNode dfs(int start, int end, int depth){
        if(start > end)
            return null;
        TreeNode node = new TreeNode(valList.get(start));
        int right_index = start;
        for(int i=start+2; i<=end; i++){
            if(depthList.get(i) == depth + 1){
                right_index = i;
                //System.out.println("--"+right_index);
                break;
            }
        }
        if(right_index != start) {
            node.left = dfs(start + 1, right_index - 1, depth + 1);
            node.right = dfs(right_index, end, depth + 1);
        } else {
            node.left = dfs(start + 1,end, depth + 1);
        }
        return node;
    }
}
