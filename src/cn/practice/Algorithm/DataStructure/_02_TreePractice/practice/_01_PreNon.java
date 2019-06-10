package cn.practice.Algorithm.DataStructure._02_TreePractice.practice;

import cn.practice.Tools.TreeNode;
import org.junit.Test;

import java.util.Stack;

/**
 * 先序非递归
 */
public class _01_PreNon {

    @Test
    public void test(){
        TreeNode root = new TreeNode(8);
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        root.left = t1;
        root.right = t2;
        t1.left = t3;
        t2.left = t4;
        t2.right = t5;
        new _01_PreNon().preOrderNon(root);
    }


    public void preOrderNon(TreeNode treeNode){
        if (treeNode.getRoot()!=null){
            Stack<TreeNode>  stack = new Stack<>();
            TreeNode p;
            stack.push(treeNode.getRoot());
            while (!stack.isEmpty()){
                p = stack.pop();
                visit(p);
                if (p.right!=null)
                    stack.push(p.right);
                if (p.left!=null)
                    stack.push(p.left);
            }
        }
    }

    public void visit(TreeNode treeNode){
        System.out.print(treeNode.val + "  ");
    }
}
