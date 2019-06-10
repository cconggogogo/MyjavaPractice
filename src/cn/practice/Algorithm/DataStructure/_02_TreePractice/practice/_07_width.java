package cn.practice.Algorithm.DataStructure._02_TreePractice.practice;

import cn.practice.Tools.TreeNode;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.HashMap;

/**
 * 求二叉树的宽度
 */
public class _07_width {

    @Test
    public void test(){
        TreeNode root = new TreeNode(8);
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        TreeNode t9 = new TreeNode(9);
        TreeNode t10 = new TreeNode(10);
        TreeNode t11 = new TreeNode(11);
        root.left = t1;
        root.right = t2;
        t1.left = t3;
        t2.left = t4;
        t2.right = t5;
        t3.right = t6;
        t4.left = t8;
        t4.right = t9;
        t5.left = t10;
        t5.right = t11;
        t6.left = t7;
        System.out.println("各层元素个数为：" + new _07_width().getWidth(root));
    }


    public HashMap<Integer,Integer> getWidth(TreeNode treeNode){
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        if (treeNode==null)  return new HashMap<>();
        hashMap.put(1,1);
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        int  level = 0;
        TreeNode last = treeNode;
        queue.add(treeNode);
        TreeNode p;
        while (!queue.isEmpty()){
            p = queue.pop();
            if (p.left!=null)
                queue.add(p.left);
            if (p.right!=null)
                queue.add(p.right);
            if (p == last){
                hashMap.put(++level + 1,queue.size());
                last = queue.peekLast();
            }
        }
        return hashMap;
    }
}
