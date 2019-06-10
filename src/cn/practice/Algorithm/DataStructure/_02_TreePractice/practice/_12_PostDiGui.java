package cn.practice.Algorithm.DataStructure._02_TreePractice.practice;

import cn.practice.Tools.TreeNode;
import org.junit.Test;

import java.util.Stack;

/**
 * 后序非递归相关的算法
 */
class NewTreeNode{
    TreeNode treeNode;
    int tag;
    public NewTreeNode(TreeNode treeNode){this.treeNode = treeNode;}
    public NewTreeNode(int tag){this.tag = tag;}
}
public class _12_PostDiGui {

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
        new _12_PostDiGui().post(root);
    }

    /**
     * 后序非递归
     * @param root
     */
    public void post(TreeNode root){
        Stack<NewTreeNode> stack = new Stack<>();
        TreeNode bt = root;
        while (bt!=null || !stack.isEmpty()){
            while (bt!=null){
                NewTreeNode newTreeNode = new NewTreeNode(bt);
                stack.push(newTreeNode);
                newTreeNode.tag = 0;
                bt = bt.left;
            }
            while (!stack.isEmpty()&&stack.peek().tag == 1){
                visit(stack.pop().treeNode);
            }
            if (!stack.isEmpty()){
                stack.peek().tag = 1;
                bt = stack.peek().treeNode.right;
            }
        }
    }

    public void visit(TreeNode treeNode){
        System.out.println(treeNode.val + "  ");
    }
}
