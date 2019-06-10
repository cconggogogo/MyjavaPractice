package cn.practice.Algorithm.Leetcode.before.Array;

import java.util.ArrayList;
/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */

class Node {
    int val;
    Node next = null;
    Node(int val) {
        this.val = val;
    }
}

class NodeList{
    Node head=null;
    public void add(int val){
        Node listNode = new Node(val);
        Node node = head;
        if (head==null){
            head=listNode;
            head.next = null;
        } else {
            while (node.next!=null){
                node = node.next;
            }
            node.next = listNode;
            listNode.next = null;
        }
    }
}



public class Test3 {
    public static void main(String[] args) {
//        ListNode listNode1 = new ListNode(12);
//        ListNode listNode2 = new ListNode(24);
//        listNode1.next = listNode2;
//        ListNode listNode3 = new ListNode(36);
//        listNode2.next = listNode3;
//        System.out.println(printListFromTailToHead(listNode1));
        NodeList nodeList = new NodeList();
        nodeList.add(12);
        nodeList.add(23);
        nodeList.add(34);
        System.out.println(printListFromTailToHead(nodeList.head));


    }

    public static ArrayList<Integer> printListFromTailToHead(Node listNode) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        Node pre=null;
        Node next=null;
        while(listNode!=null){
            next=listNode.next;
            listNode.next=pre;
            pre=listNode;
            listNode=next;
        }
        while(pre!=null){
            list.add(pre.val);
            pre=pre.next;
        }
        return list;
    }
}
