package cn.practice.MovieLearn._01structure.Tree;

public class Node {
    private int data;
    private Node left;
    private Node right;
    public Node(int data){
        this.data = data;
    }
    public void printNode(){
        if (this.left!=null){
            this.left.printNode();
        }
        System.out.print(this.data + "->");
        if (this.right!=null){
            this.right.printNode();
        }
    }

    public void addNode(int data){
        if (this.data > data){
            if (this.left == null){
                this.left = new Node(data);
            }else {
                this.left.addNode(data);
            }
        }else {
            if (this.right == null){
                this.right = new Node(data);
            }else {
                this.right.addNode(data);
            }
        }
    }
}
