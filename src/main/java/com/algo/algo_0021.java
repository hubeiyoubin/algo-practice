package com.algo;

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
        if(l1 == null && l2 == null)
            return node;

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

    public static void main(String[] args) {
        int[] nums1 = {1};
        int[] nums2 = {1, 4, 5, 6};
        ListNode node1 = new ListNode(nums1);
        ListNode node2 = new ListNode(nums2);
        System.out.println(mergeTwoLists(node1,node2));
    }
}
