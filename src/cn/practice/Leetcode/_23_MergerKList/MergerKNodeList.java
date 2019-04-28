package cn.practice.Leetcode._23_MergerKList;

import cn.practice.Tools.ListNode;
import cn.practice.Tools.ListNodeManager;

import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list.
 * Analyze and describe its complexity.
 *
 * Example:
 *
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 *
 * time: O(nlogk),k指的是多少个LinkList
 * space: O(n)
 */
public class MergerKNodeList {
    public static void main(String[] args) {
        ListNodeManager lnm = new ListNodeManager();
        lnm.add(1);
        lnm.add(4);
        lnm.add(5);
        ListNodeManager lnm2 = new ListNodeManager();
        lnm2.add(1);
        lnm2.add(3);
        lnm2.add(4);
        ListNodeManager lnm3 = new ListNodeManager();
        lnm3.add(2);
        lnm3.add(6);
        new ListNodeManager(mergeKlists(new ListNode[]{lnm.getRoot(),lnm2.getRoot(),lnm3.getRoot()})).print();
        System.out.println("-----------------");
//        new ListNodeManager(mergeKlists2(new ListNode[]{lnm.getRoot(),lnm2.getRoot(),lnm3.getRoot()})).print();
    }
    // 分治法
    public static ListNode mergeKlists(ListNode[] lists){
        if (lists == null || lists.length == 0) return null;
        return sort(lists,0,lists.length-1);
    }

    private static ListNode sort(ListNode[] lists, int i, int i1) {
        if (i >= i1) return lists[i];
        int mid = (i1 - i) / 2 + i;
        ListNode l1 = sort(lists, i, mid);
        ListNode l2 = sort(lists, mid + 1, i1);
        return meger(l1, l2);
    }

    private static ListNode meger(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val){
            l1.next = meger(l1.next, l2);
            return l1;
        } else {
            l2.next = meger(l1, l2.next);
            return l2;
        }
    }

    public static ListNode mergeKlists2(ListNode[] lists){
        if (lists == null || lists.length == 0) return null;
        // 对lists排序
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (a,b) -> a.val - b.val);
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (ListNode list: lists){
            if (list != null){
                queue.add(list);
            }
        }
        // 主要poll方法是按照顺序再剩余的序列中找到最小的
        /**
         * queue:
         * 1 2 3
         * 4 5 6
         * 7 8 9
         * poll: 1 2 3
         *
         * queue:
         * 2 3
         * 4 5 6
         * 7 8 9
         * cur: 1
         *
         */
        while (!queue.isEmpty()){
            cur.next = queue.poll();
            cur = cur.next;
            if (cur.next != null)
                queue.add(cur.next);
        }
        return dummy.next;
    }
    }
