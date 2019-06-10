package cn.practice.Algorithm.Leetcode.before._19_removeNthFromEnd;

import cn.practice.Tools.ListNode;
import cn.practice.Tools.ListNodeManager;

/**
 * 给一个链表，和数字n
 * 删除倒数第n个结点，并返回新的链表的表头
 * time: O(n);
 * space: O(1)
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNodeManager listNodeManager = new ListNodeManager();
        listNodeManager.add(1);
        listNodeManager.add(2);
        listNodeManager.add(3);
        listNodeManager.add(4);
        listNodeManager.add(5);
        listNodeManager.print();
        System.out.println();
        new ListNodeManager(removeNthFromEnd(listNodeManager.getRoot(),2)).print();
    }
    public static ListNode removeNthFromEnd(ListNode head,int n){
        // dummy记录表头的位置，指向表头
        ListNode dummy = new ListNode(0);
        ListNode slow = dummy;
        ListNode fast = dummy;
        dummy.next = head;
        for (int i = 0; i <=n; i++){
            fast = fast.next;
        }
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
