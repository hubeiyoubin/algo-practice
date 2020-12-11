package com.algo;
//给定一个二叉树
//
// struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//}
//
// 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
//
// 初始状态下，所有 next 指针都被设置为 NULL。
//
//
//
// 进阶：
//
//
// 你只能使用常量级额外空间。
// 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
//
//
//
//
// 示例：
//
//
//
// 输入：root = [1,2,3,4,5,null,7]
//输出：[1,#,2,3,#,4,5,7,#]
//解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
//
//
//
// 提示：
//
//
// 树中的节点数小于 6000
// -100 <= node.val <= 100
//
//
//
//
//
//
// Related Topics 树 深度优先搜索

import com.entity.Node;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yb
 * @date: 2020-12-11
 * 117.填充每个节点的下一个右侧节点指针2
 */
public class algo_0117 {

    public Node connect(Node root) {
        if(root == null)
            return null;
        Node cur = root;
        while(cur != null){
            //遍历当前层的时候，为了方便操作在下一
            //层前面添加一个哑结点（注意这里是访问
            //当前层的节点，然后把下一层的节点串起来）
            Node dummy = new Node(0);
            //pre表示访下一层节点的前一个节点
            Node pre = dummy;
            while(cur != null){
                Node left = cur.left;
                Node right = cur.right;
                if(left != null){
                    pre.next = left;
                    pre = pre.next;
                }
                if(right != null){
                    pre.next = right;
                    pre = pre.next;
                }
                cur = cur.next;
            }
            cur = dummy.next;
        }
        return root;
    }

    // bfs
    public Node connect_02(Node root) {
        Deque<Node> que = new LinkedList<>();
        if(root != null)
            que.offer(root);
        while(!que.isEmpty()){
            int size = que.size();
            Node last = null;
            for(int i = 0; i < size; i ++){
                Node node = que.poll();
                if(node.left != null)
                    que.offer(node.left);
                if(node.right != null)
                    que.offer(node.right);
                if(i != 0)
                    last.next = node;
                last = node;
            }
        }
        return root;
    }


}
