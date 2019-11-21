package com.algo;

/**
 * @date : 2019-11-7
 */
public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
      @Override
      public String toString(){
          StringBuilder sb = new StringBuilder();
          ListNode cur = this;
          while(cur != null){
              sb.append(cur.val);
              sb.append("-> ");
              cur = cur.next;
          }
          sb.append("null");
          return sb.toString();
      }

    public ListNode(int[] arr){
        if(arr == null || arr.length == 0 ) {
            throw new IllegalArgumentException("arr is null or empty");
        }
        this.val = arr[0];
        ListNode cur = this;
        for(int i = 1; i < arr.length; i ++){
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }
}
