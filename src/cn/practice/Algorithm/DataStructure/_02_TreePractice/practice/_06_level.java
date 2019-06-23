package cn.practice.Algorithm.DataStructure._02_TreePractice.practice;

import cn.practice.Tools.TreeNode;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Stack;

public class _06_level {

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
        new _06_level().level(root);
    }

    public void visit(TreeNode treeNode){
        System.out.print(treeNode.val + "  ");
    }

    public void level(TreeNode treeNode){
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        TreeNode q;
        if (treeNode.getRoot()!=null){
            queue.add(treeNode);
            while (!queue.isEmpty()){
                q = queue.pop();
                visit(q);
                if (q.left!=null)
                    queue.add(q.left);
                if (q.right!=null)
                    queue.add(q.right);
            }
        }
    }

    /**
     * 自下向上自右向左的层次遍历
     * @param treeNode
     */
    public void reverseLevel(TreeNode treeNode){
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode q;
        if (treeNode.getRoot()!=null){
            queue.add(treeNode);
            while (!queue.isEmpty()){
                q = queue.poll();
                stack.push(q);
                if (q.left!=null)
                    queue.add(q.left);
                if (q.right!=null)
                    queue.add(q.right);
            }
            while (!stack.isEmpty()){
                visit(stack.pop());
            }
        }
    }
}
