package cn.practice.Leetcode.Array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 最长公共字串
 */
public class Test30 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();

        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        char[] temp = new char[100];
        for (int i = 0;i<ch1.length;i++) {
            for (int j = 0;j<ch2.length;j++) {
                if (ch1[i] == ch2[j]) {
                    int m =0,a=i,b=j;
                    char[] temp2 = new char[100];
                    while (ch1[a] == ch2[j] && ch1[a]!='\0' && ch2[b]!='\0') {
                        temp2[m++] = ch1[a];
                        a++;
                        b++;
                    }
                    if(m>temp.length) {
                        temp = temp2;
                    }
                }

            }
        }
        System.out.println("最长公共字串" + Arrays.toString(temp));
    }
}
