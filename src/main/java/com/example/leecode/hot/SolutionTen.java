package com.example.leecode.hot;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class SolutionTen {
    //对链表进行操作时，我们可以引入一个dummy node，让它的next指向head，这样我们就不需要对头节点进行特殊的判断了
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy=new ListNode(0,head);
        int length=getLength(head);
        ListNode cur=dummy;
        for(int i=1;i<length-n+1;++i){
            cur=cur.next;
        }
        cur.next=cur.next.next;
        ListNode ans=dummy.next;
        return  ans;

    }
    public int getLength(ListNode head){
        int count=1;
        while(head.next!=null){
            count++;
            head=head.next;
        }
        return count;
    }
    //利用数据结构栈，先进先出
    public ListNode removeNthFromEnd2(ListNode head, int n){
        ListNode dummy=new ListNode(0,head);
        Deque<ListNode> stack=new LinkedList<ListNode>();
        ListNode cur=dummy;
        while(cur!=null){
            //入栈
            stack.push(cur);
            cur=cur.next;
        }
        for(int i=0;i<n;i++){
            //出栈：返回栈顶元素的值且不保留栈顶元素
            stack.pop();
        }
        //定义一个前驱，也就是当前的栈顶元素；peek():返回栈顶元素的的值且不弹出该元素。
        ListNode prev=stack.peek();
        prev.next=prev.next.next;
        ListNode ans =dummy.next;
        return ans;
    }
    //快慢指针，快指针比慢指针超前n个节点，这样当快指针指向末尾时，慢指针刚好指向倒数第n个节点
    public ListNode removeNthFromEnd3(ListNode head, int n){
        ListNode dummy=new ListNode(0,head);
        ListNode first=head;
        ListNode second=dummy;
        for(int i=0;i<n;i++){
            first=first.next;
        }
        while(first!=null){
        first=first.next;
        second=second.next;
        }
        second.next=second.next.next;
        ListNode ans=dummy.next;
        return ans;

    }
}
