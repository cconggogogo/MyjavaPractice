package cn.practice.Interview._360;
/**
 * 360企业安全第一题：
 * 将输入的字符串转换为int数字输出，
 * 如果是小数则去掉小数位，
 * 否则输出-1
 */

import java.util.Scanner;

public class _01_StringToInt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] chs = sc.nextLine().toCharArray();
        int res = 0;
        boolean flag = true;
        for (int i = 0; i < chs.length; i++){
            // 如果是数字就计算到结果中去
            if (chs[i] >= '0' && chs[i] <= '9'){
                res = res*10 + chs[i] - '0';
                // 如何是.，就需要考虑两种情况：后面全是数字的话，就直接舍弃掉，返回结果
                //                         后面如果有非法字符的话，就直接返回出错信息
            } else if (chs[i] == '.'){
                flag = false;
                int j;
                for (j = i + 1; j < chs.length;j++){
                    if (!(chs[j] >= '0' && chs[j] <= '9')){
                        break;
                    }
                }
                if (j<chs.length){
                    System.out.println("-1");
                } else {
                    System.out.println(res);
                }
                break;
                // 如果出现了非法的字符
            } else {
                flag = false;
                System.out.println("-1");
                break;
            }
        }
        // 只要全部是数字且不是小数的情况才会走到这里
        if (flag){
            System.out.println(res);
        }
    }
}
