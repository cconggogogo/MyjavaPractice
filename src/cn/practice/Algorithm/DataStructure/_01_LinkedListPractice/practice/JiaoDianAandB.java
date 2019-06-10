package cn.practice.Algorithm.DataStructure._01_LinkedListPractice.practice;



/**
 * 求链表A和链表B的交点
 * 要求：时间复杂度为O（N），空间复杂度为O（1）设A的长度为a+c，B的长度为b+c，
 * 其中c为尾部公共部分长度，可知a+c+b=b+c+a。
 * 当访问A链表的指针访问到链表尾部时，
 * 令它从链表B的头部开始访问链表B；同样地，
 * 当访问B链表的指针访问到链表尾部时，令它从链表A的头部开始访问链表A。
 * 这样就能控制访问A和B两个链表的指针能同时访问到交点。
 */


class LNode{
    int data;
    LNode next;
    public LNode(int data){
        this.data = data;
    }
}
public class JiaoDianAandB {
    public static LNode getJiaoDian(LNode a,LNode b){
        LNode p = a;
        LNode q = b;
        // 其实都是走了一圈，做了末尾的话自动再从另一个链表的头开始遍历
        // 重合的位置即为交点
        while (p!=q){
            p = (p == null) ? b : p.next;
            q = (q == null) ? a : q.next;
        }
        return p;
    }
}
