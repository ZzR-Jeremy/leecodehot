package com.example.leecode.zhouyu;

import com.example.leecode.hot.ListNode;

/**
 * 反转链表
 */
public class BackList {
    public ListNode iteratorListNode(ListNode head){
        ListNode prev=null, next;
        ListNode current=head;
        while(current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        return prev;
    }
}
