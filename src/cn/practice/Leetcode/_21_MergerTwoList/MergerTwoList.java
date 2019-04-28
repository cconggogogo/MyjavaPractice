package cn.practice.Leetcode._21_MergerTwoList;

import cn.practice.Tools.ListNode;
import cn.practice.Tools.ListNodeManager;

/**
 * 归并两个链表
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 *
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class MergerTwoList {
    public static void main(String[] args) {
        ListNodeManager listNodeManager = new ListNodeManager();
        listNodeManager.add(1);
        listNodeManager.add(2);
        listNodeManager.add(4);
        ListNodeManager listNodeManager1 = new ListNodeManager();
        listNodeManager1.add(1);
        listNodeManager1.add(3);
        listNodeManager1.add(4);
        new ListNodeManager(mergerTwoList(listNodeManager.getRoot(),listNodeManager1.getRoot())).print();
        System.out.println();
        new ListNodeManager(mergerTwoList2(listNodeManager.getRoot(),listNodeManager1.getRoot())).print();
    }
    // time: O(n) space: O(1)
    public static ListNode mergerTwoList(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
            }else {
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null){
            cur.next = l1;
        } else {
            cur.next = l2;
        }
        return dummy.next;
    }

    // 递归
    // time: O(n) space: O(n)
    public static ListNode mergerTwoList2(ListNode l1, ListNode l2){
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val){
            l1.next = mergerTwoList2(l1.next,l2);
            return l1;
        } else {
            l2.next = mergerTwoList2(l1,l2.next);
            return l2;
        }
    }
    }
