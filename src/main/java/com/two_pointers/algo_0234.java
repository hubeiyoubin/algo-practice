package com.two_pointers;

import com.entity.ListNode;

/**
 * @author : youbin
 * @date : 2021/1/28 22:36
 * 234 回文链表
 */
public class algo_0234 {
    public boolean isPalindrome(ListNode head) {
        if(head == null)
            return true;
        ListNode left = head, right = head;
        while(right != null && right.next != null){
            left = left.next;
            right = right.next.next;
        }
        ListNode pre = left;
        ListNode cur = left.next;
        pre.next = null;
        while(cur != null){
            ListNode node = cur.next;
            cur.next = pre;
            pre = cur;
            cur = node;
        }
        ListNode newNode = head;
        while(pre != null){
            if(pre.val != newNode.val)
                return false;
            pre = pre.next;
            newNode = newNode.next;
        }
        return true;
    }
}
