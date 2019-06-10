package cn.practice.Algorithm.DataStructure._02_TreePractice.practice;

import cn.practice.Tools.TreeNode;

import java.util.ArrayDeque;

public class _15_WPL {
    static int deep = 0;
    public static int wpl_proOrder(TreeNode root,int deep){
        int wpl = 0;
        if (root.left == null && root.right == null)
            wpl += deep*root.val;
        if (root.left!=null)
            wpl_proOrder(root.left,deep+1);
        if (root.right!=null)
            wpl_proOrder(root.right,deep+1);
        return wpl;
    }

    public int wpl_proOrder2(TreeNode treeNode){
        int wpl = 0;
        if (treeNode==null)  return 0;
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        int  level = 0;
        TreeNode last = treeNode;
        queue.add(treeNode);
        TreeNode p;
        while (!queue.isEmpty()){
            p = queue.pop();
            if (p.left==null&&p.right==null){
                wpl+=level*p.val;
            }
            if (p.left!=null)
                queue.add(p.left);
            if (p.right!=null)
                queue.add(p.right);
            if (p == last){
                level++;
                last = queue.peekLast();
            }
        }
        return wpl;
    }
}
