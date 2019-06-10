package cn.practice.Algorithm.Leetcode.cys2018._06_dynamicProgramming._01_Fibonaccisequence;

import org.junit.Test;

/**
 * 5. 母牛生产
 *
 * 题目描述：假设农场中成熟的母牛每年都会生 1 头小母牛，并且永远不会死。第一年有 1 只小母牛，从第二年开始，母牛开始生小母牛。每只小母牛 3 年之后成熟又可以生小母牛。给定整数 N，求 N 年后牛的数量。
 *
 * 第 i 年成熟的牛的数量为：
 *
 * dp[i] = dp[i-1] + dp[i-3]
 */
public class _05_cow {
    @Test
    public void test(){
        System.out.println(cow(1));
        System.out.println(cow(2));
        System.out.println(cow(3));
        System.out.println(cow(4));
        System.out.println(cow(5));
    }
    public int cow(int n){
        if (n <= 3)
            return n;
        int pre3 = 1, pre1 = 3;
        for (int i = 4; i < n; i++){
            int cur = pre1 + pre3;
            pre3 = pre1;
            pre1 = cur;
        }
        return pre1;
    }
}
