package cn.practice.Algorithm.JianZhiOffer.before._3_9;

import cn.practice.Tools.ListNode;

import java.util.ArrayList;

/**
 * 从尾到头反过来打印出每个结点的值。
 */
public class _06 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (listNode != null) {
            ret.addAll(printListFromTailToHead(listNode.next));
            ret.add(listNode.val);
        }
        return ret;
    }

}
