package cn.practice.Algorithm.JianZhiOffer.before;

import cn.practice.Tools.TreeNode;
import org.junit.Test;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。
 * （ps：我们约定空树不是任意一个树的子结构）
 * 思路：递归，注意对空指针的判断很重要。
 */
public class SonTree {
    @Test
    public void test() {
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

        TreeNode root2 = new TreeNode(8);
        TreeNode t11 = new TreeNode(1);
        TreeNode t22 = new TreeNode(2);
        TreeNode t33 = new TreeNode(3);
        root2.left = t11;
        root2.right = t22;
        t11.left = t33;
        System.out.println(HasSubtree(root, root2));
        TreeNode root3 = null;
        System.out.println(HasSubtree(root, root3));
    }

    private boolean Doroot1hasroot2(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        } else if (root1 == null) {
            return false;
        }

        if (root1.val != root2.val)
            return false;

        return Doroot1hasroot2(root1.left, root2.left) && Doroot1hasroot2(root1.right, root2.right);

    }

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        // 空树不是任何树的子树
        boolean result = false;
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                result = Doroot1hasroot2(root1, root2);
            }

            if (!result) {
                result = HasSubtree(root1.left, root2);
            }
            if (!result) {
                result = HasSubtree(root1.right, root2);
            }
        }
        return result;
    }
}
