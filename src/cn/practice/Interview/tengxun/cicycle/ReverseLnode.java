package cn.practice.Interview.tengxun.cicycle;

/**
 * 链表反转
 */
public class ReverseLnode {
    public static void main(String[] args) {
        LNode h1 = new LNode(1);
        LNode h2 = new LNode(2);
        LNode h3 = new LNode(3);
        h1.next = h2;
        h2.next = h3;
        LNode node = reverse(h1);
        while (node != null){
            System.out.print(node.data + ", ");
            node = node.next;
        }
    }
    public static LNode reverse(LNode head){
        LNode newHead = null;
        LNode p = head;
        LNode pre = null;
        while (p != null){
            LNode q = p.next;
            if (q == null) newHead = p;
            p.next = pre;
            pre = p;
            p = q;
        }
        return newHead;
    }
}
