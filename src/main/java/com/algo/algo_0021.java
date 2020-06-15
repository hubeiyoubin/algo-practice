package com.algo;

import com.entity.ListNode;

/**
 * @date : 2019-11-21
 *
 * 21. 合并两个有序链表
 *
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 */
public class algo_0021 {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode node = dummy;
        while(l1 != null || l2 != null){
            if(l1 == null){
                node.next = l2;
                break;
            }
            if(l2 == null){
                node.next = l1;
                break;
            }
            if(l1.val < l2.val){
                node.next = new ListNode(l1.val);
                node = node.next;
                l1 = l1.next;
            }else if((l1.val == l2.val)){
                node.next = new ListNode(l1.val);
                node.next.next = new ListNode(l2.val);
                node = node.next.next;
                l1 = l1.next;
                l2 = l2.next;
            }else{
                node.next = new ListNode(l2.val);
                node = node.next;
                l2 = l2.next;
            }
        }
        return dummy.next;
    }

    //递归解法
    //其实递归就是程序内部维护了一个栈。
    // 这个题就是每次都把最小值压入栈，最后出栈的时候，将所有数连在一起就可以了。
    // 说白了，就是用一个栈维护了顺序。
    // 最后的连接，当然是小的连小的，所以l1 小，就连到 l1,l2 小就连到 l2，最后先返回的，就是最小的头结点。
    public ListNode mergeTwoListsRe(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }

        if(l1.val < l2.val) {
            l1.next = mergeTwoListsRe(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsRe(l1, l2.next);
            return l2;
        }
    }
    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {1, 4, 5, 6};
        ListNode node1 = new ListNode(nums1);
        ListNode node2 = new ListNode(nums2);
        System.out.println(mergeTwoLists(node1,node2));
    }
}
