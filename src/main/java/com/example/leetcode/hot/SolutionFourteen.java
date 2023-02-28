package com.example.leetcode.hot;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolutionFourteen {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans=null;
        for(int i=0;i<lists.length;++i){
            ans=mergeTwoList(ans,lists[i]);
        }
        return ans;
    }
    //分治
    public ListNode mergeKLists1(ListNode[] lists){
        return merge(lists,0,lists.length-1);
    }
    public ListNode merge(ListNode[] lists, int l,int r){
        if(l==r){
            return lists[l];
        }
        if(l>r){
            return null;
        }
        /**
         * 比特操作 右移一位，相当于除以2向下取整
         * x=13:0000 1101 -> x;0000 0110=6
         */
        int mid=(l+r)>>1;
        return mergeTwoList(merge(lists,l,mid),merge(lists,mid+1,r));
    }
    public ListNode mergeTwoList(ListNode a,ListNode b){
        if(a==null||b==null){
            return a!=null?a:b;
        }
        ListNode head=new ListNode(0);
        ListNode tail=head,aPtr=a,bPtr=b;
        while (aPtr!=null&&bPtr!=null){
            if(aPtr.val<bPtr.val){
                tail.next=aPtr;
                aPtr=aPtr.next;
            }else{
                tail.next=bPtr;
                bPtr=bPtr.next;
            }
            tail=tail.next;
        }
        tail.next=(aPtr!=null?aPtr:bPtr);
        return head.next;
    }

}
