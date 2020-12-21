package com.algo;
//在本问题中，有根树指满足以下条件的有向图。该树只有一个根节点，所有其他节点都是该根节点的后继。每一个节点只有一个父节点，除了根节点没有父节点。
//
// 输入一个有向图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边
//不属于树中已存在的边。
//
// 结果图是一个以边组成的二维数组。 每一个边 的元素是一对 [u, v]，用以表示有向图中连接顶点 u 和顶点 v 的边，其中 u 是 v 的一个父节点。
//
//
// 返回一条能删除的边，使得剩下的图是有N个节点的有根树。若有多个答案，返回最后出现在给定二维数组的答案。
//
// 示例 1:
//
// 输入: [[1,2], [1,3], [2,3]]
//输出: [2,3]
//解释: 给定的有向图如下:
//  1
// / \
//v   v
//2-->3
//
//
// 示例 2:
//
// 输入: [[1,2], [2,3], [3,4], [4,1], [1,5]]
//输出: [4,1]
//解释: 给定的有向图如下:
//5 <- 1 -> 2
//     ^    |
//     |    v
//     4 <- 3
//
//
// 注意:
//
//
// 二维数组大小的在3到1000范围内。
// 二维数组中的每个整数在1到N之间，其中 N 是二维数组的大小。

import java.util.*;

/**
 * @author yb
 * @date: 2020-12-21
 * 685.冗余连接 2
 */
public class algo_0685 {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int inDegree[] = new int[edges.length + 1]; // 记录节点入度
        for (int i = 0; i < edges.length; i++) {
            inDegree[edges[i][1]]++; // 统计入度
        }
        List<Integer> list = new ArrayList<>(); // 记录入度为2的边（如果有的话就两条边）
        // 找入度为2的节点所对应的边，注意要倒叙，因为优先返回最后出现在二维数组中的答案
        for (int i = edges.length - 1; i >= 0; i--) {
            if (inDegree[edges[i][1]] == 2) {
                list.add(i);
            }
        }
        // 处理图中情况1 和 情况2
        // 如果有入度为2的节点，那么一定是两条边里删一个，看删哪个可以构成树
        if (list.size() > 0) {
            if (isTreeAfterRemoveEdge(edges, list.get(0))) {
                return edges[list.get(0)];
            } else {
                return edges[list.get(1)];
            }
        }
        // 处理图中情况3
        // 明确没有入度为2的情况，那么一定有有向环，找到构成环的边返回就可以了
        return getRemoveEdge(edges);
    }

    // 在有向图里找到删除的那条边，使其变成树
    int[] getRemoveEdge(int[][] edges){
        init(edges.length);
        for(int i =0; i< edges.length; i++){
            // 构成有向环了，就是要删除的边
            if(connect(edges[i][0], edges[i][1])){
                return edges[i];
            }
            union(edges[i][0], edges[i][1]);
        }
        return null;
    }

    boolean isTreeAfterRemoveEdge(int[][] edges, int deleteEdge) {
        init(edges.length); // 初始化并查集
        for (int i = 0; i < edges.length; i++) {
            if (i == deleteEdge) continue;
            if (connect(edges[i][0], edges[i][1])) { // 构成有向环了，一定不是树
                return false;
            }
            union(edges[i][0], edges[i][1]);
        }
        return true;
    }




    // 并查集
    int[] parents;
    private void init(int n){
        parents = new int[n+1];
        for(int i = 1; i <= n; i++){
            parents[i] = i;
        }
    }

    private int find(int x){
        // 根节点的parent[i] == i
        while(parents[x] != x) {
            // 路径压缩
            parents[x] = parents[parents[x]];
            x = parents[x];
        }
        return x;
    }

    private void union(int p, int q){
        int rootP = find(p);
        int rootQ = find(q);
        if(rootP == rootQ)
            return;
        parents[rootP] = rootQ;
    }
    private boolean connect(int p, int q){
        return find(p) == find(q);
    }
}
