package cn.practice.MyPractice;

import cn.practice.Tools.ListNode;
import cn.practice.Tools.ListNodeManager;

public class RverseKGroup {
    public static void main(String[] args) {
        ListNodeManager lnm = new ListNodeManager();
        lnm.add(1);
        lnm.add(2);
        lnm.add(3);
        lnm.add(4);
        lnm.add(5);
        lnm.print();
        System.out.println();
        new ListNodeManager(reverseKgroup(lnm.getRoot(),2)).print();
    }
    public static ListNode reverseKgroup(ListNode head, int k){
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        int count = 0;
        while (count < k){
            cur = cur.next;
            count++;
        }
        if (count == k){
            cur = reverseKgroup(cur,k);
            while (count-- > 0){
                ListNode temp = head.next;
                head.next = cur;
                cur = head;
                head = temp;
            }
            head = cur;
        }
        return head;
    }
}
