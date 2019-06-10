package cn.practice.Interview.tengxun.cicycle;
class LNode{
    public int data;
    public LNode next;
    public LNode(int data){this.data = data;}
}

/**
 * 判断链表是否有环，以及环的入口，环的长度
 * 快慢指针
 */
public class hasCicycle {
    public static void main(String[] args) {
        LNode h1 = new LNode(3);
        LNode h2 = new LNode(5);
        LNode h3 = new LNode(0);
        h1.next = h2;
        h2.next = h3;
        h3.next = h1;
        System.out.println("是否有环: " + hasCicycle(h1));
        System.out.println("环的入口结点为：" + findEntrance(h1).data);
        System.out.println("环的长度为：" + getCicycleLength(h1));
    }

    public static boolean hasCicycle(LNode head){
        LNode slow = head;
        LNode fast = head;
        while (fast!=null && fast.next!=null){
            if (slow == fast)
                return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    public static LNode findEntrance(LNode head){
        LNode slow = head;
        LNode fast = head;
        while (fast!=null && fast.next!=null){
            if (slow == fast)
                break;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast == null || fast.next == null){
            return null;
        }
        slow = head;
        while (slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        return  slow;
    }

    public static int getCicycleLength(LNode head){
        LNode entrance = findEntrance(head);
        int length = 1;
        LNode start = entrance.next;
        while (entrance != start){
            start = start.next;
            length++;
        }
        return length;
    }
}
