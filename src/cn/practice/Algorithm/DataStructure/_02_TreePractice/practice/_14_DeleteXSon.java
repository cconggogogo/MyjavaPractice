package cn.practice.Algorithm.DataStructure._02_TreePractice.practice;

import cn.practice.Tools.TreeNode;

/**
 * 删除元素x的子树
 */
public class _14_DeleteXSon {
    public void deleteTree(TreeNode root,int key){
        if (root!=null){
            TreeNode search = new _05_Bianli().search(root, key);
            deleteTree(root.left,key);
            deleteTree(root.right,key);
            root = null;
        }
    }
}
