package cn.practice.Algorithm.myCodePractice;

import cn.practice.Tools.TreeNode;

import java.util.ArrayDeque;
import java.util.Stack;

public class _03_TreeTest {

    int preValue = Integer.MIN_VALUE;

    public void visit(TreeNode root){
        System.out.println(root.val);
    }

    public void pre(TreeNode root){
        if (root!=null){
            visit(root);
            pre(root.left);
            pre(root.right);
        }
    }

    public void pre2(TreeNode root){
        if (root!=null){
            Stack<TreeNode> stack = new Stack<>();
            TreeNode p;
            stack.push(root);
            while (!stack.isEmpty()){
                p = stack.pop();
                visit(p);
                if (root.right != null){
                    stack.push(root.right);
                }
                if (root.left != null){
                    stack.push(root.left);
                }
            }
        }
    }

    public void in(TreeNode root){
        if (root != null){
            Stack<TreeNode> stack = new Stack<>();
            TreeNode p;
            stack.push(root);
            while (!stack.isEmpty() || root != null){
                while (root != null){
                    p = stack.pop();
                    stack.push(p);
                    root = root.left;
                }
                if (!stack.isEmpty()){
                    visit(root);
                    root = root.right;
                }
            }
        }
    }

    public void post(TreeNode root){
        if (root != null){
            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();
            TreeNode p;
            stack1.push(root);
            while (!stack1.isEmpty()){
                p = stack1.pop();
                stack2.push(p);
                if (root.left != null){
                    stack1.push(root.left);
                }
                if (root.right != null){
                    stack1.push(root.right);
                }
            }
        }
    }

    public int getDepth(TreeNode root){
        if (root == null)
            return 0;
        int LD, RD;
        LD = getDepth(root.left);
        RD = getDepth(root.right);
        return LD < RD ? RD + 1 : LD + 1;
    }

    public int getMinDepth(TreeNode root){
        if (root == null) return 0;
        if (root.left == null) return getMinDepth(root.right);
        if (root.right == null) return getMinDepth(root.left);
        else {
            int LD, RD;
            LD = getDepth(root.left);
            RD = getDepth(root.right);
            return LD > RD ? RD + 1 : LD + 1;
        }
    }

    public int getMaxDepth(TreeNode root){
        if (root == null)  return 0;
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        TreeNode p;
        queue.add(root);
        TreeNode last = root;
        int level = 0;
        while (!queue.isEmpty()){
            p = queue.pop();
            if (p.left != null){
                queue.add(p.left);
            }
            if (p.right != null){
                queue.add(p.right);
            }
            if (p == last){
                level++;
                last = queue.peekLast();
            }
        }
        return level;
    }

    // level初值为1
    public void getDepth(TreeNode root, int level, int value){
        if (root == null) return;
        if (root.val == value){
            return;
        }
        level++;
        getDepth(root.left,level,value);
        getDepth(root.right,level,value);
        level--;
    }

    public void level(TreeNode root){
        if (root == null) return;
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        TreeNode p;
        while (!queue.isEmpty()){
            p = queue.pop();
            if (p.left != null){
                queue.add(p.left);
            }
            if (p.right != null){
                queue.add(p.right);
            }
        }
    }

    public int singleLeaf(TreeNode root){
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        else
            return singleLeaf(root.left) + singleLeaf(root.right);
    }

    public int oneLeaf(TreeNode root){
        if (root == null) return 0;
        if (root.left == null && root.right == null)
            return 0;
        if (root.left !=null && root.right !=null)
            return oneLeaf(root.left) + oneLeaf(root.right);
        else
            return oneLeaf(root.left) + oneLeaf(root.right) + 1;
    }

    public int doubleLeaf(TreeNode root){
        if (root == null) return 0;
        if (root.left !=null && root.right !=null)
            return doubleLeaf(root.left) + doubleLeaf(root.right) + 1;
        else
            return doubleLeaf(root.left) + doubleLeaf(root.right);
    }

    public boolean judgeBT(TreeNode root){
        if (root == null) return true;
        else {
            boolean flag = judgeBT(root.left);
            if (flag == false || preValue > root.val)
                return false;
            preValue = root.val;
            return judgeBT(root.right);
        }
    }

    public void findBT(TreeNode root, int key){
        if (root == null){
            TreeNode treeNode = new TreeNode();
            treeNode.val = key;
            treeNode.left = null;
            treeNode.right = null;
        } else if (key > root.val){
            findBT(root.right,key);
        } else if (key < root.val){
            findBT(root.left, key);
        } else {
            return;
        }
    }

    public void swapNodes(TreeNode root){
        if (root != null){
            swapNodes(root.left);
            swapNodes(root.right);
            TreeNode treeNode = root.left;
            root.left = root.right;
            root.right = treeNode;
        }
    }

    public int wpl(TreeNode root, int deep){
        int wpl = 0;
        if (root.left == null && root.right == null)
            wpl += deep * root.val;
        if (root.left != null)
            wpl(root.left, deep + 1);
        if (root.right != null)
            wpl(root.right, deep + 1);
        return wpl;
    }
}
