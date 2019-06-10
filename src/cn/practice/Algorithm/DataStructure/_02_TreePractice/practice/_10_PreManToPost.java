package cn.practice.Algorithm.DataStructure._02_TreePractice.practice;

/**
 * 满二叉树中中序数组转换为后序数组
 */
public class _10_PreManToPost {
    public void PreToPost(int[] pre,int[] post,int l1,int r1,int l2,int r2){
        if (l1<r1){
            post[r2] = pre[l1];
            PreToPost(pre,post,l1+1,(l1+r1+1)/2,l2,(l2+r2-1)/2);
            PreToPost(pre,post,(l1+r1+1)/2+1,(l1+r1+1)/2,(l2+r2-1)/2,r2-1);
        }
    }
}
