package cn.practice.Tools;



public class TreeDemo {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = null;
        treeNode2.right = null;
        treeNode3.left = null;
        treeNode3.right = null;
    }
}


