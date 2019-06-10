package cn.practice.Algorithm.Leetcode.cys2018._03_GreedyAlgorithm;

import org.junit.Test;

/**
 * 4. 买卖股票最大的收益
 *
 * 题目描述：一次股票交易包含买入和卖出，只进行一次交易，求最大收益。
 *
 * 只要记录前面的最小价格，将这个最小价格作为买入价格，然后将当前的价格作为售出价格，查看当前收益是不是最大收益。0，那么就把 prices[i] - prices[i-1] 添加到收益中。
 */
public class _05_maxProfit {
    @Test
    public void test(){
        int[] prices = {1,5,2,8,4};
        System.out.println(maxProfit(prices));
    }
    public int maxProfit(int[] prices){
        int n = prices.length;
        if (n == 0) return 0;
        int soFarMin = prices[0];
        int max = 0;
        for (int i = 1; i < n; i++){
            if (soFarMin > prices[i]) soFarMin = prices[i];
            else {
                max = Math.max(max, prices[i] - soFarMin);
            }
        }
        return max;
    }
}
