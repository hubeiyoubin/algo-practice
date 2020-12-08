package com.algo;

/**
 * @author yb
 * @date: 2020-12-8
 */
//给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
//
// 示例:
//
// 输入: 3
//输出: 5
//解释:
//给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
// Related Topics 树 动态规划
// 👍 915 👎 0
public class algo_0096 {

    public int numTrees(int n) {
        int[][] G = new int[n+1][n+1];
        G[0][0] = 1;
        G[0][1] = 1;
        G[1][0] = 1;
        G[1][1] = 1;
        // G[n][n] = G[n-1][n-1] + G[n-1][n]
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
              G[i][j] = G[1][j - 1] * G[i - j][i];
              G[i][i] = G[i-1][i-1] + G[i-1][i];
            }
        }
        return G[n][n];
    }

    public int numTrees_(int n) {
        //F(i,n)=G(i−1)⋅G(n−i)
        int[] G = new int[n+1];
        G[0] = 1;
        G[1] = 1;
        G[2] = 2;
        G[3] = 5;
        if(G[n] != 0){
            return G[n];
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }

    public static void main(String[] args) {
        System.out.println(new algo_0096().numTrees(3));
    }

    // time out
    public int numTrees_02(int n) {
        if(n == 0){
            return 0;
        }
        int[] G = new int[n+1];
        return numCount(G, 1, n);
    }

    private int numCount(int[] G,int start, int end) {
        int count = 0;
        if(start >= end)
            return 1;
        if(G[end - start] != 0){
            return G[end - start];
        }
        for(int i = start; i <= end; i ++){
            int left = numCount(G, start, i - 1);
            int right = numCount(G,i + 1, end);
            count= count + left * right;
        }
        G[end - start] = count;
        return count;
    }
}
