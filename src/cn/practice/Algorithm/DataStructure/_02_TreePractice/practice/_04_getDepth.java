package cn.practice.Algorithm.DataStructure._02_TreePractice.practice;

import cn.practice.Tools.TreeNode;
import org.junit.Test;

import java.util.ArrayDeque;

/**
 * 获得树最大高度
 */
public class _04_getDepth {
    public static int level = 1;

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
        root.left = t1;
        root.right = t2;
        t1.left = t3;
        t2.left = t4;
        t2.right = t5;
        t3.right = t6;
        t6.left = t7;
//        System.out.println(new _04_getDepth().getDepth2(root));
        _04_getDepth.getLevelInValue(root,2);
    }


    /**
     * 递归
     * @param treeNode
     * @return
     */
    public int getDepth(TreeNode treeNode){
        int LD,RD;
        if (treeNode==null) return 0;
        else {
            LD = getDepth(treeNode.left);
            RD = getDepth(treeNode.right);
            return LD>RD? LD+1:RD+1;
        }
    }

    /**
     * 求树的最小高度
     * @param treeNode
     * @return
     */
    public int getMinDepth(TreeNode treeNode){
        int LD, RD;
        if (treeNode == null) return 0;
        if (treeNode.left == null) return getMinDepth(treeNode.right);
        if (treeNode.right == null) return getMinDepth(treeNode.left);
        else {
            LD = getMinDepth(treeNode.left);
            RD = getMinDepth(treeNode.right);
            return LD < RD ? LD + 1 : RD + 1;
        }
    }

    public int getDepth2(TreeNode treeNode){
        if (treeNode==null)  return 0;
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
                level++;
                last = queue.peekLast();
            }
        }
        return level;
    }

    public static void getLevelInValue(TreeNode treeNode,int value){
        if (treeNode!=null){
            if (treeNode.val == value)
                System.out.println(level);
            ++level;
            getLevelInValue(treeNode.left,value);
            getLevelInValue(treeNode.right,value);
            --level;
        }
    }
}
