package cn.practice.Algorithm.feibolaqi;

/**
 * 题目描述：有N阶楼梯，每次可以上一阶或者两阶，求有多少种上楼梯的方法。
 * 定义一个数组dp存储上楼梯的方法数（为了方便讨论，数组下标从1开始），
 * dp[i]表示走到第i个楼梯的方法数目。
 * 第i个楼梯可以从第i-1和i-2个楼梯再走一步到达
 * ，走到第i个楼梯的方法数为走到第i-1和第i-2个楼梯的方法数
 */
public class FeiBoLaQiArray {
    public static void main(String[] args) {
        System.out.println(method(2));
        System.out.println(method(3));
        System.out.println(method(4));
    }
    public static int method(int n){
        if (n <= 2)
            return n;
        return method(n - 1) + method(n - 2);
    }
}
