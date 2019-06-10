package cn.practice.Interview.tengxun.cicycle;

/**
 * 求链表的中间结点
 */
public class MidLnode {
    public static void main(String[] args) {
        LNode h1 = new LNode(1);
        LNode h2 = new LNode(2);
        LNode h3 = new LNode(3);
        LNode h4 = new LNode(4);
        LNode h5 = new LNode(5);
        LNode h6 = new LNode(6);
        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h5;
        h5.next = h6;
        System.out.println(getMidLnode(h1).data);
    }
    public static LNode getMidLnode(LNode head){
        LNode p = head;
        LNode q = head;
        while (q!=null && q.next!=null){
            p = p.next;
            q = q.next.next;
        }
        return p;
    }
}
