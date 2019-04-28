package cn.practice.Tools;

public class ListNodeManager {
    private ListNode root;
    private int currentIndex;
    public ListNodeManager(){}
    public ListNodeManager(ListNode root){
        this.root = root;
    }
    public ListNode getRoot(){
        return root;
    }
    public ListNode add(int data){
        if (root == null){
            root = new ListNode(data);
        }else {
            root.addNode(data);
        }
        return root;
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
            ListNode newNode = new ListNode(data);
            newNode.next = root;
            root = newNode;
        } else {
            root.insertNode(index,data,currentIndex);
        }
    }
}
