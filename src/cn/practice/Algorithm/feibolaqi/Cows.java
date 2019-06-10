package cn.practice.Algorithm.feibolaqi;

/**
 * 母牛生产问题；第一年有一头小母牛，3年之后每年都生一头小母牛，假设都不死，
 * 第n年共有多少母牛，输出n从1到20的母牛数目
 *
 * dp[i] = dp[i-1] + dp[i-3]
 * dp[i]指的是第i年成熟的奶牛的数量
 */
public class Cows {
    public static void main(String[] args) {
        for (int i = 1; i <= 20; i++){
            System.out.println("第" + i + "年共有" + numbers(i) + "只母牛");
        }
    }
    public static int numbers(int n){
        if (n <= 3)
            return n;
        else {
            return numbers(n - 1) + numbers(n - 3);
        }
    }
}
