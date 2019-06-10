package cn.practice.Algorithm.DataStructure._02_TreePractice.practice;

import cn.practice.Tools.TreeNode;
import org.junit.Test;

import java.util.Stack;

/**
 * 中序非递归
 */
public class _02_InNon {
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
        new _02_InNon().inNon(root);
    }


    public void inNon(TreeNode treeNode){
        if (treeNode.getRoot()!=null){
            Stack<TreeNode> stack = new Stack<>();
            TreeNode p;
            p = treeNode;
            while (!stack.isEmpty()|| p!=null){
                while (p!=null){
                    stack.push(p);
                    p = p.left;
                }
                if(!stack.isEmpty()){
                    p = stack.pop();
                    visit(p);
                    p = p.right;
                }
            }
        }
    }

    public void visit(TreeNode treeNode){
        System.out.print(treeNode.val + "  ");
    }
}
