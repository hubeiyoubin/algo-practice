package com.algo;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @date : 2019-11-22
 *
 * 23. 合并k个排序链表
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 */
public class algo_0023 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

    // 递归写法，两两合并，直到最后一个
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        return mergeListNode(lists, head ,0, lists.length - 1);
    }

    private ListNode mergeListNode(ListNode[] lists, ListNode head, int start, int end) {
        if(start == end){
            head.next = lists[start];
            return head.next;
        }
        int mid = start + (end  - start >> 2);
        ListNode left = mergeListNode(lists, head, start, mid);
        ListNode right = mergeListNode(lists, head, mid + 1, end);
        return mergeLeftRight(head,left,right);
    }

    private ListNode mergeLeftRight(ListNode head ,ListNode left, ListNode right) {
        ListNode cur = head;
        while(left != null || right != null){
            if(left == null){
                cur.next = right;
                break;
            }
            if(right == null){
                cur.next = left;
                break;
            }
            if(left.val < right.val){
                cur.next = new ListNode(left.val);
                cur = cur.next;
                left = left.next;
            }else{
                cur.next = new ListNode(right.val);
                cur = cur.next;
                right = right.next;
            }
        }
        return head.next;
    }

    @Test
    public void testMerge(){
        int[] num1 = {1,2,3,4,10};
        int[] num2 = {2,6,7,11};
        int[] num3 = {3,6,7,11};
        int[] num4 = {5,6,7,11};
        int[] num5 = {1};
        ListNode list1 = new ListNode(num1);
        ListNode list2 = new ListNode(num2);
        ListNode list3 = new ListNode(num3);
        ListNode list4 = new ListNode(num4);
        ListNode list5 = new ListNode(num5);
        ListNode[] lists = {list1,list2,list3,list4,list5};
        System.out.println(mergeKLists(lists));
    }

    // 非递归写法，两两合并，直到最后一个
    public ListNode mergeKLists_02(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null;
        int left = 0; int right = lists.length - 1;
        while(right > 0) {
            while(left < right) {
                lists[left] = merge(lists[left], lists[right]);
                left++;
                right--;
            }
            left = 0;
        }
        return lists[0];
    }

    private ListNode merge(ListNode node1, ListNode node2) {
        ListNode head = new ListNode(0);
        ListNode pre = head;
        while(node1 != null && node2 != null) {
            if(node1.val < node2.val){
                pre.next = node1;
                node1 = node1.next;
                pre = pre.next;
            } else {
                pre.next = node2;
                node2 = node2.next;
                pre = pre.next;
            }
        }
        pre.next = node1 == null ? node2 : node1;
        return head.next;
    }
}
