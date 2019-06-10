package cn.practice.Algorithm.Leetcode.before._25_RverseKGroup;

import cn.practice.Tools.ListNode;
import cn.practice.Tools.ListNodeManager;

/**
 * 链表分为k组：
 * 举例：
 * 1 -> 2 -> 3 -> 4 -> 5
 * k =2;
 * 2 -> 1 -> 4 -> 3 -> 5
 *
 * k = 3;
 * 3 -> 2 -> 1 -> 4 -> 5
 *
 * time:O(n)
 * space: O(n)
 */
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
        new ListNodeManager(reverseKGroup(lnm.getRoot(),2)).print();
//        new ListNodeManager(reverseKGroup(lnm.getRoot(),3)).print();
    }
    public static ListNode reverseKGroup(ListNode head, int k){
        if (head == null || head.next == null) return head;
        int count = 0;
        ListNode cur = head;
        while (cur != null && count != k){
            cur = cur.next;
            count++;
        }
        if (count == k){
            cur = reverseKGroup(cur,k);
            // 核心代码
            while (count-- > 0){
                // cur指向的是后半段的头
                // 尾插法
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
