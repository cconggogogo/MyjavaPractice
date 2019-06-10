package cn.practice.Interview.huawei;

import java.util.Scanner;

/**
 * 输入整数m，代表下面有m行
 * 下面的m行由数字0和1组成的等长的字符串，
 * 返回这个矩阵中正方形的最大面积
 * 举例：
 *
 * 3
 * 110
 * 111
 * 110
 *
 * 返回：4
 */
public class Main22 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        String[] strs = new String[m];
        for (int i = 0; i < m; i++) {
            strs[i] = input.next();
        }
        int max0 = findmax(strs, '0');
        int max1 = findmax(strs, '1');
        System.out.println(Math.max(max0, max1));

    }

    public static int findmax(String[] strs, char ch) {
        int m = strs.length;
        int n = strs[0].length();
        int[][] dp = new int[m + 1][n + 1];
        int max = 0;

        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (strs[i - 1].charAt(j - 1) == ch) {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }
}
