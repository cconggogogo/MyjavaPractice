package cn.practice.Leetcode.Array;

/**
 * 输入一颗二叉树的跟节点和一个整数，
 * 打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 */

import java.util.ArrayList;

public class Test24 {
    public static ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    public static ArrayList<Integer> list = new ArrayList<Integer>();
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root == null)
            return listAll;
        list.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null){
            ArrayList<Integer> arrayList = new ArrayList<>(list);
            listAll.add(arrayList);
        }
        FindPath(root.left, target);
        FindPath(root.right, target);
        // 深度遍历完一条路径后要回退
        list.remove(list.size()-1);
        return listAll;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(6);
        TreeNode treeNode5 = new TreeNode(2);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(5);
        TreeNode treeNode8 = new TreeNode(4);
        TreeNode treeNode9 = new TreeNode(5);
        TreeNode treeNode10 = new TreeNode(2);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;

        treeNode4.left = null;
        treeNode4.right = null;

        treeNode5.left = treeNode8;
        treeNode5.right = null;

        treeNode6.left = null;
        treeNode6.right = treeNode9;

        treeNode7.left = null;
        treeNode7.right = treeNode10;

        treeNode8.left = null;
        treeNode8.right = null;

        treeNode9.left = null;
        treeNode9.right = null;

        treeNode10.left = null;
        treeNode10.right = null;

        ArrayList<ArrayList<Integer>> lists = Test24.FindPath(treeNode1,10);
        for (int x=0;x<lists.size();x++){
            System.out.println(lists.get(x));
        }

    }
}