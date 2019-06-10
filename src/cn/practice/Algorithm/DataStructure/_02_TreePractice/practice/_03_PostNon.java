package cn.practice.Algorithm.DataStructure._02_TreePractice.practice;

import cn.practice.Tools.TreeNode;
import org.junit.Test;

import java.util.Stack;

/**
 * 后续非递归
 */
public class _03_PostNon {

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
        new _03_PostNon().postNon(root);
    }


    public void postNon(TreeNode treeNode){
        if (treeNode.getRoot()!=null){
            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();
            stack1.push(treeNode);
            TreeNode p;
            while (!stack1.isEmpty()){
                p = stack1.pop();
                stack2.push(p);
                if (p.left!=null)
                    stack1.push(p.left);
                if (p.right!=null)
                    stack1.push(p.right);
            }
            while (!stack2.isEmpty()){
                p = stack2.pop();
                visit(p);
            }
        }
    }

    public void visit(TreeNode treeNode){
        System.out.print(treeNode.val + "  ");
    }
}
