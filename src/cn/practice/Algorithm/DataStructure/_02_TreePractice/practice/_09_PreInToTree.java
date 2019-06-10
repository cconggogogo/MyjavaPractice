package cn.practice.Algorithm.DataStructure._02_TreePractice.practice;

import cn.practice.Tools.TreeNode;
import org.junit.Test;

/**
 * 根据前序和中序构造二叉树
 */
public class _09_PreInToTree {
    @Test
    public void test(){
        int[] pre = {1,2,4,5,3,6};
        int[] in = {4,2,5,1,3,6};
        new _05_Bianli().preOrder(new _09_PreInToTree().createBt(pre,in,0,5,0,5));
    }
    public TreeNode createBt(int[] pre,int[] in,int l1,int r1,int l2,int r2){
        TreeNode s = new TreeNode();
        int i ;
        if (l1>r1) return null;
        for (i = l2;i<r2;i++){
            if (pre[l1] == in[i])
                break;
        }
        s.val = in[i];
        s.left = createBt(pre,in,l1+1,i-l2+l1,l2,i-1);
        s.right = createBt(pre,in,l1+i-l2+1,r1,i+1,r2);
        return s;
    }
}

