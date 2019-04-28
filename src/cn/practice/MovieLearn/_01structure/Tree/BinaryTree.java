package cn.practice.MovieLearn._01structure.Tree;

public class BinaryTree {
    private Node root;
    public void add(int data){
        if (root == null){
            root = new Node(data);
        } else {
            root.addNode(data);
        }
    }
    public void print(){
        root.printNode();
    }

}
