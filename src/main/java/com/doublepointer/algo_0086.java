package com.doublepointer;

import com.entity.ListNode;

/**
 * @author yb
 * @date: 2021-1-28
 * 86 分隔链表
 */
public class algo_0086 {
    /**
     *  分开两个链表，再合并
     * @param head
     * @param x
     * @return
     */
    public ListNode partition_(ListNode head, int x) {
        if(head == null)
            return null;
        ListNode large = new ListNode(-1);
        ListNode small = new ListNode(-1);
        ListNode largeNode = large;
        ListNode smallNode = small;
        while(head != null){
            if(head.val >= x){
                largeNode.next = head;
                largeNode = largeNode.next;
            } else {
                smallNode.next = head;
                smallNode = smallNode.next;
            }
            head = head.next;
        }
        largeNode.next = null;
        smallNode.next = large.next;
        return small.next;
    }

    /**
     * 双指针解法
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null)
            return null;
        ListNode p = new ListNode(0), slow = p, fast = head.next;
        slow.next = head;
        while (fast != null) {
            if (slow.next.val < x) {
                slow = slow.next;
                head = fast;
            } else if (fast.val < x) {
                head.next = fast.next;
                fast.next = slow.next;
                //slow = slow.next = fast;
                slow.next = fast;
                slow = slow.next;
            } else {
                head = fast;
            }
            fast = head.next;
        }
        return p.next;
    }
}
