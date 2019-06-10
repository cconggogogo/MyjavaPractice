package cn.practice.Tools;

public class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(){}

    public TreeNode getRoot(){
        return this;
    }
}
