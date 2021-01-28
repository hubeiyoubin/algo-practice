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
}
