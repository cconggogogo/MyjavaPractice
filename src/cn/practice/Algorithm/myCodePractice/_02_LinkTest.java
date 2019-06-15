package cn.practice.Algorithm.myCodePractice;

import cn.practice.Tools.ListNode;

public class _02_LinkTest {
    public ListNode deleteDuplicate(ListNode head){
        if (head == null || head.next == null) return head;
        head.next = deleteDuplicate(head.next);
        return head.getData() == head.next.getData() ? head.next : head;
    }

    public ListNode hasCirycle(ListNode head){
        ListNode left = head, right = head;
        while (left != null && right.next != null){
            if (left == right)
                break;
            left = left.next;
            right = right.next.next;
        }
        if (left == null || right == null)
            return null;
        left = head;
        while (left != right){
            left = left.next;
            right = right.next;
        }
        return left;
    }

    public ListNode getCicycle(ListNode head1, ListNode head2){
        ListNode p = head1, q = head2;
        while (p != q){
            p = (p == null) ? head2 : p.next;
            q = (q == null) ? head1 : q.next;
        }
        return p;
    }

    public ListNode reverseLNode(ListNode head){
        ListNode p = head;
        ListNode pre = null;
        while (p != null){
            ListNode q = p.next;
            p.next = pre;
            pre = p;
            p = q;
        }
        return head;
    }

    public int getCicycleLength(ListNode head){
        ListNode entrance = hasCirycle(head);
        ListNode p = entrance.next;
        int length = 1;
        while (p != entrance){
            length++;
            p = p.next;
        }
        return length;
    }
}
