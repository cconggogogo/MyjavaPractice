package cn.practice.Algorithm.Leetcode.cys2018._06_dynamicProgramming._01_Fibonaccisequence;

/**
 * 2. 强盗抢劫
 *
 * 题目描述：抢劫一排住户，但是不能抢邻近的住户，求最大抢劫量。
 *
 * 定义 dp 数组用来存储最大的抢劫量，其中 dp[i] 表示抢到第 i 个住户时的最大抢劫量。
 *
 * 由于不能抢劫邻近住户，如果抢劫了第 i -1 个住户，那么就不能再抢劫第 i 个住户，所以
 */
public class _02_rob {
    public int rob(int[] nums){
        int pre2 = 0, pre1 = 0;
        for (int i = 0; i < nums.length;i++){
            int cur = Math.max(pre2 + nums[i], pre1);
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }
}
