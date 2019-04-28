package cn.practice.MyPractice;
/**
 * 链表元素两两交换
 */

import cn.practice.Tools.ListNode;
import cn.practice.Tools.ListNodeManager;

public class swapPairs {
    public static void main(String[] args) {
        ListNodeManager lnm = new ListNodeManager();
        lnm.add(1);
        lnm.add(2);
        lnm.add(3);
        lnm.add(4);
        lnm.print();
        System.out.println();
        new ListNodeManager(swapPairs(lnm.getRoot())).print();
    }
    public static ListNode swapPairs(ListNode head){
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode l1 = dummy;
        ListNode l2 = head;
        while (l2!=null&&l2.next!=null){
            ListNode nextStart = l2.next.next;
            l1.next = l2.next;
            l2.next.next = l2;
            l2.next = nextStart;
            l1 = l2;
            l2 = l2.next;
        }
        return dummy.next;
    }
}
