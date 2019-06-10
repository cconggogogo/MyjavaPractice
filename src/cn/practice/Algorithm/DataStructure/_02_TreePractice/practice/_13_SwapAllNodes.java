package cn.practice.Algorithm.DataStructure._02_TreePractice.practice;

import cn.practice.Tools.TreeNode;

/**
 * 交换二叉树的左右子树
 */
public class _13_SwapAllNodes {
    public void swap(TreeNode treeNode){
        if (treeNode!=null){
            swap(treeNode.left);
            swap(treeNode.right);
            TreeNode treeNode1 = treeNode.left;
            treeNode.left = treeNode.right;
            treeNode.right = treeNode1;
        }
    }
}
