package com.two_pointers;

import com.entity.ListNode;

/**
 * @author yb
 * @date: 2021-1-28
 * 61 旋转链表
 */
public class algo_0061 {
    //设立一个头指针和尾指针，遍历一次链表得到链表的长度n。
    // 并将尾指针的next指向头指针，同时将head指针和尾指针向后移动n-k个元素，返回新head
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null)
            return null;
        if(head.next == null)
            return head;
        ListNode tailNode = head;
        // 链表长度
        int n = 1;
        while(tailNode.next != null){
            n++;
            tailNode = tailNode.next;
        }
        // 移动位数 等于 链表长度，则表示不用移动，直接返回head即可
        if(k % n == 0)
            return head;
        // 将尾指针指向 head指针
        tailNode.next = head;
        int move = n - (k % n);
        ListNode newTail = head;
        while(move > 1){
            newTail = newTail.next;
            move --;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }
}
