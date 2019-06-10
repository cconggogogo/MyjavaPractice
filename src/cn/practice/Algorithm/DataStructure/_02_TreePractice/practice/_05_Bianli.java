package cn.practice.Algorithm.DataStructure._02_TreePractice.practice;

import cn.practice.Tools.TreeNode;

/**
 * 先中后三种遍历
 */
public class _05_Bianli {
    public void preOrder(TreeNode treeNode){
        if (treeNode!=null){
            visit(treeNode);
            preOrder(treeNode.left);
            preOrder(treeNode.right);
        }
    }

    public void inOrder(TreeNode treeNode){
        if (treeNode!=null){
            inOrder(treeNode.left);
            visit(treeNode);
            inOrder(treeNode.right);
        }
    }

    public void postOrder(TreeNode treeNode){
        if (treeNode!=null){
            postOrder(treeNode.left);
            postOrder(treeNode.right);
            visit(treeNode);
        }
    }

    /**
     * 求树中指定的值是否存在，应用
     * @param treeNode
     */
    public TreeNode search(TreeNode treeNode,int key){
        if (treeNode!=null){
            if (treeNode.val == key){
                return treeNode;
            }
            search(treeNode.left,key);
            search(treeNode.right,key);
        }
        return null;
    }

    public void visit(TreeNode treeNode){
        System.out.println(treeNode.val + "  ");
    }
}
