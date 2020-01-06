package com.algo;

/**
 * @date : 2020-1-6
 * 206. 反转链表
 */
public class algo_0206 {

    //非递归写法
    public ListNode reverseList(ListNode head) {
        if(head == null)
            return head;
        ListNode cur = head;
        ListNode pre = null;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    //第一种，递归写法, 递进的时候改变链表指针指向
    public ListNode reverseList2(ListNode head) {
        if(head == null)
            return head;
        ListNode cur = head;
        return reverseList2(cur, null);
    }

    private ListNode reverseList2(ListNode cur, ListNode pre) {
        if(cur == null)
            return pre;
        ListNode next = cur.next;
        cur.next = pre;
        return reverseList2(next,cur);
    }

    //第二种，递归写法， 回归的时候改变链表指针指向
    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode newHead = reverseList3(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}

