package com.example.leetcode.hot;

/**
 * 合并两个有序链表
 */
public class SolutionTwelve {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null) return list2;
        else if(list2==null) return list1;
        else if(list1.val<list2.val){
            list1.next=mergeTwoLists(list1.next,list2);
            //System.out.println("list1="+list1.val);
            return list1;
        }else {
            list2.next=mergeTwoLists(list1,list2);
            //System.out.println("list2="+list2.val);
            return list2;
        }
    }
}
