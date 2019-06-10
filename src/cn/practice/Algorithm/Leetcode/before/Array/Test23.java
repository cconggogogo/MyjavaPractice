package cn.practice.Algorithm.Leetcode.before.Array;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */

/**
 * 分析：
 * 链接：https://www.nowcoder.com/questionTerminal/a861533d45854474ac791d90e447bafd
 * 来源：牛客网
 *
 * BST的后序序列的合法序列是，对于一个序列S，最后一个元素是x （也就是根），
 * 如果去掉最后一个元素的序列为T，
 * 那么T满足：T可以分成两段，前一段（左子树）小于x，
 * 后一段（右子树）大于x，且这两段（子树）都是合法的后序序列。
 * 完美的递归定义 : )
 */

/**
 * 分析：二叉搜索树(BST),中序遍历的结果是递增的
 */
public class Test23 {
    public static boolean verifySquenceOfBST(int[] arr) {
        if (arr.length == 0)
            return false;
        return judge(arr,0,arr.length-1);
    }
    public static boolean judge(int[] arr, int l, int r){
        if (l>= r) return true;
        int i = r;
        while (i>1 && arr[i-1] > arr[r])
            --i;
        for (int j=i-1;j>=1;--j)
            if (arr[j]>arr[r])
                return false;
            return judge(arr,l,i-1) && judge(arr,i,r-1);
    }

    public static void main(String[] args) {
        int[] arr = {1,3,4,2,7,6,10,9,8,5 };
        int[] arr2 = {1,3,2};
        System.out.println(verifySquenceOfBST(arr));
    }
}
