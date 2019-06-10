package cn.practice.Others._03_MovieLearn._01structure.LinkedList;

/**
 * 一种常见的基础数据结构，是一种线性表，
 * 但是并不会按线性的顺序存储数据，而是在每一个节点里存到是下一个节点的指针（Pointer）。
 */
class Node{
    private int data;
    public Node next;
    public Node(int data){
        this.data = data;
    }
    public int getData(){
        return data;
    }

    public void setData(int data){
        this.data = data;
    }
    public void addNode(int data){
        if (this.next == null){
            this.next = new Node(data);
        }else {
            this.next.addNode(data);
        }
    }
    public void delNode(int data){
        if (this.next!=null){
            if (this.next.data ==data){
                this.next = this.next.next;
            }else {
                this.next.delNode(data);
            }
        }
    }
    public void printNode(){
        if (this.next!=null){
            System.out.print(this.next.data + "->");
            this.next.printNode();
        }
        System.out.println();
    }
    // 查找结点是否存在
    public boolean findNode(int data){
        if (this.next!=null){
            if (this.next.data == data){
                return true;
            }else {
                return this.next.findNode(data);
            }
        }
        return false;
    }
    public boolean updateNode(int oldData,int newData){
        if (this.next!=null){
            if (this.next.data == oldData){
                this.next.data = newData;
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
            Node newNode = new Node(data);
            newNode.next = this.next;
            this.next = newNode;
        } else {
            this.next.insertNode(index,data,currentIndex);
        }
    }
}
