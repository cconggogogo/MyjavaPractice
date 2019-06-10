package cn.practice.Algorithm.DataStructure._01_LinkedListPractice.practice;

/**
 * 链表反转
 */
public class LianBiaoReverse_01 {
    /**
     * ：递归的方式
     * @param head
     * @return
     */
    public static LNode reverseList(LNode head){
        if (head == null || head.next == null)
            return head;
        LNode next = head.next;
        LNode newHead = reverseList(next);
        next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 非递归
     * @param head
     * @return
     */
    public static LNode reverseList2(LNode head){
        LNode p = head;
        LNode pre = null;
        while (p != null){
            LNode q = p.next;
            p.next = pre;
            pre = p;
            p = q;
        }
        return head;
    }
}
