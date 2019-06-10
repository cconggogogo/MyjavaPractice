package cn.practice.Others._03_MovieLearn._01structure.LinkedList;

public class NodeManager {
    private Node root;
    private int currentIndex = 0; // 结点的序号，每次从0开始
    public void add(int data){
        if (root == null){
            root = new Node(data);
        }else {
            root.addNode(data);
        }
    }
    public void del(int data){
        if (root == null){
            return;
        } else {
            root.delNode(data);
        }
    }
    // 打印所有
    public void print(){
        if (root!=null){
            System.out.print(root.getData() + "->");
            root.printNode();
        }
        System.out.println();
    }
    public boolean find(int data){
        if (root == null)
            return false;
        if (root.getData() == data){
            return true;
        } else
            return root.findNode(data);
    }
    public boolean update(int oldData,int newData){
        if (root == null)
            return false;
        if (root.getData() == oldData){
            root.setData(newData);
            return true;
        }else {
            return root.updateNode(oldData,newData);
        }
    }
    // 向索引之前插入
    public void insert(int index,int data){
        if (index<0) return;
        currentIndex = 0;
        if (index == currentIndex){
            Node newNode = new Node(data);
            newNode.next = root;
            root = newNode;
        } else {
            root.insertNode(index,data,currentIndex);
        }
    }
}
