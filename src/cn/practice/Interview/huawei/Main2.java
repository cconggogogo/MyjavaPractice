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
public class Main2 {
    public static void matrixWithAllones(int[][] B,int m,int n){
        int [][] res = new int[m][n];
        int max_of_s,max_i,max_j;
        for (int i = 0;i<m;i++){
            res[i][0] = B[i][0];
        }
        for (int j = 0;j<n;j++){
            res[0][j] = B[0][j];
        }
        for (int i = 1;i<m;i++){
            for (int j = 1;j<n;j++){
                if (B[i][j] == 1)
                    res[i][j] = Math.min(res[i][j-1],Math.min(res[i-1][j-1],res[i-1][j])) + 1;
                else
                    res[i][j] =0;
            }
        }
        max_of_s = res[0][0];
        max_i = 0;
        max_j = 0;
        for (int i = 0;i<m;i++){
            for (int j = 0;j<n;j++){
                if (res[i][j]>max_of_s){
                    max_of_s = res[i][j];
                    max_i = i;
                    max_j = j;
                }
            }
        }
        System.out.println(max_of_s * max_of_s);
    }

    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        int m = sc1.nextInt(); // 行数
        int n = 0;
        int k = 0;
        int[][] B = new int[m][100];
        Scanner sc = new Scanner(System.in);
        while (k<m){
            char[] str1 = sc.nextLine().toCharArray();
            n = str1.length;
            for (int i = 0;i<str1.length;i++){
                B[k][i] = str1[i] - '0';
            }
            k++;
        }
        matrixWithAllones(B,m,n);
    }
}
