package cn.practice.Algorithm.DataStructure._02_TreePractice.practice;

import cn.practice.Tools.TreeNode;

/**
 * 二叉排序树相关
 */
public class _11_SortedTree {
    static int predt = Integer.MIN_VALUE;
    /**
     * 判断给定的树是否是二叉排序树
     */
    public static boolean judgeBT(TreeNode treeNode){
        boolean b1,b2;
        if (treeNode == null) return true;
        else {
            b1 = judgeBT(treeNode.left);
            if (b1 == false || treeNode.val < predt)
                return false;
            predt = treeNode.val;
            b2 = judgeBT(treeNode.right);
            return b2;
        }
    }


    /**
     * 插入
     */public void insert(TreeNode treeNode,int key){
         if (treeNode == null){
             TreeNode root = new TreeNode(key);
             root.left = null;
             root.right = null;
         } else {
             if (key == treeNode.val)
                 return;
             else if (key > treeNode.val){
                 insert(treeNode.right,key);
             } else {
                 insert(treeNode.left,key);
             }
         }
    }

    /**
     * 查找
     * @param treeNode
     * @param key
     * @return
     */
    public TreeNode search(TreeNode treeNode,int key){
        if (treeNode == null) return null;
        else {
            if (treeNode.val == key)
                return treeNode;
            else if (treeNode.val > key){
                return search(treeNode.right,key);
            }else {
                return search(treeNode.left,key);
            }
        }
    }
}
