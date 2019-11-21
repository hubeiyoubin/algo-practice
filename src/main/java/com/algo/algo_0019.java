package com.algo;

/**
 * @date : 2019-11-20
 *
 * 19. 删除链表的倒数第N个节点
 *
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 *
 */
public class algo_0019 {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode start = dummyNode;
        ListNode end = dummyNode;
        while(n-- > 0){
            end = end.next;
            //n --;
        }
        while(end.next != null){
            start = start.next;
            end = end.next;
        }
        ListNode del = start.next;
        start.next = start.next.next;
        del.next = null;
        return dummyNode.next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        ListNode head = new ListNode(nums);
        System.out.println(head);
        System.out.println(new algo_0019().removeNthFromEnd(head, 7));
    }

}
