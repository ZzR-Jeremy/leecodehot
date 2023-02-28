package com.example.leetcode.zuo;

import com.example.leetcode.hot.ListNode;
import org.springframework.boot.autoconfigure.web.servlet.JspTemplateAvailabilityProvider;

import java.util.*;

/**
 * 哈希表
 * 有序表
 * 单链表
 * 双链表
 */
public class day4_test {

    public static void main(String[] args) {

        /** hash表
         * 如果key是基本数据类型 哈希表内部按照值来传递的,拷贝一份传递给需要的
         * 内存占用就是其本身
         * key如果是一个类 则会拷贝内存地址
         * 内存占用一律8字节 不会影响hash表内存
         *
         * 性能都是常数级别的
         */
        HashSet<Integer> hashSet = new HashSet<Integer>();
        hashSet.add(3);
        System.out.println(hashSet.contains(3));
        hashSet.remove(3);
        System.out.println(hashSet.contains(3));


        HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
        hashMap.put(1, "Z");
        hashMap.put(1, "R");
        hashMap.put(2, "X");
        System.out.println(hashMap.containsKey(1));
        System.out.println(hashMap.get(1));
        System.out.println(hashMap.get(4));
        hashMap.remove(2);
        System.out.println(hashMap.get(2));


        /** 有序表 TreeSet  TreeMap
         * 所有Key之间是有组织的
         * hash是无序组织key 有序表是有序组织Key
         *hash能实现的它都能实现
         *
         * 性能不如hashMap O(logn)
         */
        TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>();
        //要求Key是可以比较的
        treeMap.put(7, "7");
        treeMap.put(3, "3");
        treeMap.put(8, "8");
        treeMap.put(2, "2");
        treeMap.put(6, "6");
        System.out.println(treeMap.containsKey(1));
        System.out.println(treeMap.get(2));
        System.out.println(treeMap.firstKey());
        System.out.println(treeMap.lastKey());
        System.out.println(treeMap.floorKey(8) + "<=8,离8最近");
        System.out.println(treeMap.ceilingEntry(8) + ">8，离8最近");

    }

    /**
     * 单链表反转
     * 双链表反转
     */
    public ListNode listReverse(ListNode head) {
        ListNode prev = null, next;
        ListNode curr = head;
        while (curr.next != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public ListNode listReverse1(ListNode head){
        if (head==null||head.next==null) return head;
        else{
            ListNode newHead=listReverse1(head.next);
            head.next.next=head;
            head.next=null;
            return newHead;
        }
    }
    /**
     * 打印两个有序链表的公共部分
     * 谁小谁移动，有公共的输出后共同移动
     */
    public void printSamePart(ListNode list1, ListNode list2){
        while(list1.next!=null&&list2.next!=null){
            if (list1.val<list2.val) list1=list1.next;
            else if (list1.val==list2.val) {
                System.out.println(list1.val);
                list1=list1.next;
                list2=list2.next;
            }else {
                list2=list2.next;
            }
        }
    }
    /**
     * 判断一个链表是不是回文结构
     */
    public boolean isPalindrome(ListNode head) {
        if (head==null||head.next==null) return true;
        Stack stack=new Stack();
        ListNode cur=head;
        while (cur!=null){
            stack.push(cur.val);
            cur=cur.next;
        }
        while (!stack.empty()){
            if (Integer.parseInt(String.valueOf(stack.peek()))==head.val){
                head=head.next;
                stack.pop();
            }else return false;
        }
        return true;
    }
    /**
     * 快慢指针
     * 快指针一次走两步 慢指针一次走一步
     * 快指针走的长度是 慢指针的二倍所以 当快指针走完的时候 慢指针恰好走到中间的位置
     */
    public boolean isPalindrome1(ListNode head){
        if (head==null||head.next==null) return true;
        ListNode slow=head;
        ListNode fast=head;
        while(fast != null && fast.next != null){
            slow=slow.next;
            fast=fast.next.next;
        }
        if (fast!=null){
            slow=slow.next;
        }
        Stack stack=new Stack();
        while (slow!=null){
            stack.push(slow.val);
            slow=slow.next;
        }
        while(!stack.empty()){
            if(Integer.parseInt(String.valueOf(stack.peek()))==head.val){
                stack.pop();
                head=head.next;
            }else return false;
        }
        return true;
    }

}
