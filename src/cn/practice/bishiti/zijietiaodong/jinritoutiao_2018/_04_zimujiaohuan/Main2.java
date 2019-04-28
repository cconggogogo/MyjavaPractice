package cn.practice.bishiti.zijietiaodong.jinritoutiao_2018._04_zimujiaohuan;
/**
 * 【编码题】字符串S由小写字母构成，长度为n。定义一种操作，
 * 每次都可以挑选字符串中任意的两个相邻字母进行交换。
 * 询问在至多交换m次之后，字符串中最多有多少个连续的位置上的字母相同？
 *
 * 输入描述:
 *
 * 第一行为一个字符串S与一个非负整数m。(1 <= |S| <= 1000, 1 <= m <= 1000000)
 * 输出描述:
 *
 * 一个非负整数，表示操作之后，连续最长的相同字母数量。
 * 输入例子1:
 *
 * abcbaa 2
 * 输出例子1:
 *
 * 2
 * 例子说明1:
 *
 * 使2个字母a连续出现，至少需要3次操作。即把第1个位置上的a移动到第4个位置。
 * 所以在至多操作2次的情况下，最多只能使2个b或2个a连续出现。
 * 思路：动态规划
 *
 * 步骤：（1）先将字母及字母出现的位置存储在二维数组binStr[][]中，
 * 行表示字符串的第i个位置，列表示对应的字母；
 *
 * （2）逐次取出每个字母（最多26个），将其出现位置存储在一维数组location[]中;
 *
 * （3）然后通过动态规划方法，从少到多将相同字母交换相近，如果交换次数没有超出限制，
 * 则检查此时交换后相同连续出现的字母是不是最长。
 *
 * 各个字母在限制内移动次数得到的最大长度保存在num[]数组中。
 */

import java.util.Scanner;

public class Main2 {
    public static int dp(int i, int j, int[] location) {
        if (i == j) {
            return 0;
            /**
             * 比如：
             * location为：
             * 'a':[1,3,5],下标：0,1,2  ;
             * 参数为：i=0,j=1,location
             * 返回：3-1-1,只需要要移动1次即可
             */
        } else if (i + 1 == j) { // 这两个字母是相邻的
            return location[j] - location[i] - 1;
        } else { // 不是相邻的，中间还要其他的字母
            //（j-i-1）表示中间还有相同字母个数（相当于i+1=j时中间相同字母个数为0）
            /**
             * 理解：
             * 0 1 2 3 4 5 6 7 8
             * b a c a b c a b a
             *   i             ii
             *   0   1     2   3
             *   可以先算中间部分的次数：dp(i + 1, j - 1, location)
             *   总共的步数(元素的个数):location[j] - location[i]
             *   中间重复的元素的个数：(j - i - 1)
             */
            return dp(i + 1, j - 1, location) + location[j] - location[i] - (j - i - 1) - 1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int len = str.length();
        char[] arrStr = str.toCharArray();
        int m = sc.nextInt();
        int[][] binStr = new int[arrStr.length][26];
        for (int i = 0; i < arrStr.length; i++) {
            binStr[i][arrStr[i] - 'a'] = 1;
        }
        for(int i = 0;i <binStr.length;i++ ){
            for(int j = 0;j < 26 ;j++){
                System.out.print(binStr[i][j] + "  ");
            }
            System.out.println();
        }
        int[] num = new int[26];//记录每个字母最长数量(规定移动次数范围内)
        for (int j = 0; j < 26; j++) {//第i个字母
            int[] location = new int[len];
            int k = 0;
            for (int i = 0; i < len; i++) {
                if (binStr[i][j] == 1)
                    location[k++] = i;
            }
            if (k == 1) {//字符串中只有一个字母
                num[j] = 1;
            } else {
                int temp = -1;
                for (int i = 0; i < k; i++) {
                    for (int ii = i + 1; ii < k; ii++) {
                        int re = dp(i, ii, location);
                        // 最多交换m次
                        if (re <= m) {
                            // 最终的长度
                            if (ii - i + 1 > temp) {
                                temp = ii - i + 1;
                            }
                        }
                    }
                }
                num[j] = temp;
            }
        }
        int sum = num[0];
        for (int i = 1; i < 26; i++) {
            if (num[i] > sum) {
                sum = num[i];
            }
        }
        System.out.println(sum);
    }
}