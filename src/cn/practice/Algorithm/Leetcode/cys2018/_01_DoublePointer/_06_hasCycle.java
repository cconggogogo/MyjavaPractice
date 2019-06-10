package cn.practice.Algorithm.Leetcode.cys2018._01_DoublePointer;

import cn.practice.Tools.ListNode;

/**
 * 6. 判断链表是否存在环
 *
 * 使用双指针，一个指针每次移动一个节点，一个指针每次移动两个节点，
 * 如果存在环，那么这两个指针一定会相遇。
 */
public class _06_hasCycle {
    public boolean hasCycle(ListNode root){
        if (root == null)
            return false;
        ListNode l1 = root, l2 = root.next;
        while (l1!=null && l2!=null & l2.next!=null){
            if (l1 == l2)
                return true;
            l1 = l1.next;
            l2 = l2.next.next;
        }
        return false;
    }
}
