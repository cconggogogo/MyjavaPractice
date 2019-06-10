package cn.practice.Algorithm.Leetcode.before.Array;

/**
 * 反转链表，返回新链表的表头
 */
public class Test15 {
    public static ListNode ReverseList(ListNode head) {
        if(head==null)
            return null;
        ListNode reversedHead=null;
        ListNode current=head;
        ListNode tmp=null;
        ListNode pre=null;
        while(current!=null){
            // 从前往后的过程中反转链表
            tmp=current.next;
            current.next=pre;
            if(tmp==null)
                reversedHead=current;
            pre=current;
            current=tmp;

        }
        return reversedHead;
    }
}
