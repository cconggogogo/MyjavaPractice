package cn.practice.Algorithm.DataStructure._02_TreePractice.practice;

import cn.practice.Tools.TreeNode;
import org.junit.Test;

public class _08_Count {

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
        System.out.println("结点数：" + new _08_Count().count(root));
        System.out.println("叶子结点数：" + new _08_Count().leaf(root));
        System.out.println("单分支结点数：" + new _08_Count().singleLeaf(root));
        System.out.println("双分支结点数：" + new _08_Count().doubleLeaf(root));
    }

    /**
     * 计算结点数
     * @param treeNode
     * @return
     */
    public int count(TreeNode treeNode){
        int n1,n2;
        if (treeNode == null) return 0;
        else {
            n1 = count(treeNode.left);
            n2 = count(treeNode.right);
        }
        return n1 + n2 +1;
    }

    /**
     * 计算叶子结点数
     */
    public int leaf(TreeNode treeNode){
        int n1,n2;
        if (treeNode == null) return 0;
        else if (treeNode.left ==null && treeNode.right == null)
            return 1;
        else {
            n1 = leaf(treeNode.left);
            n2 = leaf(treeNode.right);
            return n1 + n2;
        }
    }

    /**
     * 单分支结点数
     */
    public int singleLeaf(TreeNode treeNode){
        if (treeNode == null) return 0;
        if (treeNode.left == null && treeNode.right == null) return 0;
        if (treeNode.left!=null && treeNode.right!=null)
            return singleLeaf(treeNode.left) + singleLeaf(treeNode.right);
        else
            return 1 + singleLeaf(treeNode.left) + singleLeaf(treeNode.right);
    }

    /**
     * 双分支结点数
     */
    public int doubleLeaf(TreeNode treeNode){
        if (treeNode == null) return 0;
        if (treeNode.left!=null && treeNode.right!=null)
            return singleLeaf(treeNode.left) + singleLeaf(treeNode.right) + 1;
        else
            return singleLeaf(treeNode.left) + singleLeaf(treeNode.right);
    }
}
