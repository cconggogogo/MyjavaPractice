package cn.practice.Algorithm.Leetcode.before.Array;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 轴对称
 */
public class Test18 {
    public void Mirror(TreeNode root) {
        TreeNode tmp = null;
        if (root != null)
        {
            tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            if (root.left != null)
                Mirror(root.left);
            if (root.right != null)
                Mirror(root.right);
        }
    }

    public static void main(String[] args) {
        Test18 test18 = new Test18();
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = null;
        treeNode2.right = null;
        treeNode3.left = null;
        treeNode3.right = null;

        System.out.println(treeNode1.val);
        System.out.println(treeNode1.left.val);
        System.out.println(treeNode1.right.val);
        System.out.println("=================");

        test18.Mirror(treeNode1);
        System.out.println(treeNode1.val);
        System.out.println(treeNode1.left.val);
        System.out.println(treeNode1.right.val);
    }
}
