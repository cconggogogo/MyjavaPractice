package cn.practice.Algorithm.Leetcode.cys2018._01_DoublePointer;

/**
 * 2. 两数平方和
 *
 * 题目描述：判断一个数是否为两个数的平方和。
 */
public class _02_judgeSquareSum {
    public boolean judgeSquareSum(int c){
        int i = 0,j = (int)Math.sqrt(c);
        while (i <= j){
            int powSum = i * i + j * j;
            if (powSum == c)
                return true;
            else if (powSum > c)
                j--;
            else
                i++;
        }
        return false;
    }
}
