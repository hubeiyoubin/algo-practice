package com.two_pointers;

import com.entity.ListNode;

/**
 * @author yb
 * @date: 2021-1-28
 */
public class algo_0142 {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null)
            return null;
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while(fast != null && fast.next != null){
            if(slow == fast) break;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(slow != fast){
            return null;
        }
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }


    public ListNode detectCycle_(ListNode head) {
        if(head == null || head.next == null)
            return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }
        if(slow != fast){
            return null;
        }
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
