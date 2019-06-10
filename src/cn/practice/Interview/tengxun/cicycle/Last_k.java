package cn.practice.Interview.tengxun.cicycle;
/**
 * 求链表中的倒数第k个结点
 */
public class Last_k {
    public static void main(String[] args) {
        LNode h1 = new LNode(1);
        LNode h2 = new LNode(2);
        LNode h3 = new LNode(3);
        LNode h4 = new LNode(4);
        LNode h5 = new LNode(5);
        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h5;
        System.out.println(last_k(h1,3).data);
    }
    public static LNode last_k(LNode head,int k){
        LNode p = head;
        LNode q = head;
        int count = 1;
        while (q.next!=null){
            if (count >= k){
                p = p.next;
            }
            q = q.next;
            count++;
        }
        if (p == head)
            return null;
        else {
            return p;
        }
    }
}
