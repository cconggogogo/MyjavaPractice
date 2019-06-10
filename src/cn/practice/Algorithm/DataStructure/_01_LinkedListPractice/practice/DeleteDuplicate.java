package cn.practice.Algorithm.DataStructure._01_LinkedListPractice.practice;

/**
 * 删除有序链表中的重复结点
 */
public class DeleteDuplicate {
    public static LNode deleteDuplicate(LNode head){
        if (head == null || head.next == null) return head;
        head.next = deleteDuplicate(head.next);
        return head.data == head.next.data ? head.next : head;
    }
}
