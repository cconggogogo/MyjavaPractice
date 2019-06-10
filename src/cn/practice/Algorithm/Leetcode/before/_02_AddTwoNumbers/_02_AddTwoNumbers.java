package cn.practice.Algorithm.Leetcode.before._02_AddTwoNumbers;

import cn.practice.Tools.ListNode;
import cn.practice.Tools.ListNodeManager;

/**
 * Input:[2 -> 4 -> 6] + [5 -> 6 -> 4]
 * output:7 -> 0 -> 1 -> 1
 * time:O(n)
 * space:O(n)
 */
public class _02_AddTwoNumbers {
    public static void main(String[] args) {
        // 建立第一个链表
        ListNodeManager lnm1 = new ListNodeManager();
        lnm1.add(2);
        lnm1.add(4);
        lnm1.add(6);
        // 建立第二个链表
        ListNodeManager lnm2 = new ListNodeManager();
        lnm2.add(5);
        lnm2.add(6);
        lnm2.add(4);
        // 打印结果的链表
        new ListNodeManager(addTwoNumbers(lnm1.getRoot(),lnm2.getRoot())).print();
    }
    public static ListNode addTwoNumbers(ListNode l1,ListNode l2){
        ListNode dummy = new ListNode(0); // 表头
        int sum = 0;
        ListNode cur = dummy; // 存储整个表的结构
        ListNode p1 = l1,p2 = l2;
        while (p1!=null || p2!=null){
            if (p1!=null){
                sum+=p1.val;
                p1 = p1.next;
            }
            if (p2!=null){
                sum+=p2.val;
                p2=p2.next;
            }
            cur.next = new ListNode(sum%10);
            sum/=10;
            cur = cur.next;
        }
        // 处理最后一次可能的进位：比如：11
        if (sum == 1)
            cur.next = new ListNode(1);
        return dummy.next;
    }
}
