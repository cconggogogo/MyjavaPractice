package cn.practice.Algorithm.DataStructure._01_LinkedListPractice.practice;

/**
 * 归并两个有序的链表
 */
public class GuiBingTwoSortedList {
    public static void main(String[] args) {

    }
    public static LNode mergerList(LNode h1,LNode h2){
        if (h1 == null) return h2;
        if (h2 == null) return h1;
        if (h1.data < h2.data){
            mergerList(h1.next,h2);
            return h1;
        }
        else {
            mergerList(h1,h2.next);
            return h2;
        }
    }
}
