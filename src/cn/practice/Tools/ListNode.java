package cn.practice.Tools;

import java.util.List;

public class ListNode {
    public int val;
    public ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }

    public void addNode(int data){
        if (this.next == null){
            this.next = new ListNode(data);
        }else {
            this.next.addNode(data);
        }
    }

    public int getData(){
        return val;
    }

    public void setData(int data){
        this.val = data;
    }
    public void delNode(int data){
        if (this.next!=null){
            if (this.next.val ==data){
                this.next = this.next.next;
            }else {
                this.next.delNode(data);
            }
        }
    }
    public void printNode(){
        if (this.next!=null){
            System.out.print(this.next.val + "->");
            this.next.printNode();
        }
        System.out.println();
    }
    // 查找结点是否存在
    public boolean findNode(int data){
        if (this.next!=null){
            if (this.next.val == data){
                return true;
            }else {
                return this.next.findNode(data);
            }
        }
        return false;
    }
    public boolean updateNode(int oldData,int newData){
        if (this.next!=null){
            if (this.next.val == oldData){
                this.next.val = newData;
                return true;
            }else {
                return this.next.updateNode(oldData,newData);
            }
        }
        return false;
    }

    public void insertNode(int index,int data,int currentIndex){
        currentIndex++;
        if (index == currentIndex){
            ListNode newNode = new ListNode(data);
            newNode.next = this.next;
            this.next = newNode;
        } else {
            this.next.insertNode(index,data,currentIndex);
        }
    }
}