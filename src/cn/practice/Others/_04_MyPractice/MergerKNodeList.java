package cn.practice.Others._04_MyPractice;

import cn.practice.Tools.ListNode;

import java.util.PriorityQueue;

public class MergerKNodeList {
    public static void main(String[] args) {

    }
    public static ListNode mergeKlists2(ListNode[] lists){
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(lists.length,(x,y) -> x.val-y.val);
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (ListNode listNode: lists){
            if (listNode!=null){
                priorityQueue.add(listNode);
            }
        }
        while (!priorityQueue.isEmpty()){
            cur.next = priorityQueue.poll();
            cur = cur.next;
            if (cur.next!=null){
                priorityQueue.add(cur.next);
            }
        }
        return dummy.next;
    }
}
