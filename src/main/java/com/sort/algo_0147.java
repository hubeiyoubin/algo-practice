package com.sort;

import com.entity.ListNode;

/**
 * @author yb
 * @date: 2021-2-18
 *
 * 147 对链表进行插入排序
 */
public class algo_0147 {
    /**
     * 链表的插入排序， 画图
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode last = head;
        ListNode cur = head.next;
        while(cur != null){
            if(last.val <= cur.val){
                last = last.next;
            } else {
                ListNode pre = dummy;
                while(pre.next.val <= cur.val){
                    pre = pre.next;
                }
                last.next = cur.next;
                cur.next = pre.next;
                pre.next = cur;
            }
            cur = last.next;
        }
        return dummy.next;
    }
}
