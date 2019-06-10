package cn.practice.Interview.huawei;

import java.util.Scanner;

/**
 * 判断两个ip地址和子网掩码的与运算的结果是否相同，
 * 相同返回true(代表属于同一个网段)，否则返回false
 * 同时返回第一个ip地址的十进制表示
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine(); // 两个ip地址和一个子网掩码组成的字符串
        String[] strings = str.split(" ");
        String[] testStr = strings[2].split("\\."); // 子网掩码字符数组
        StringBuilder[] str1 = new StringBuilder[2];
        str1[0] = new StringBuilder(); // 保留第一个ip和子网掩码交的结果
        str1[1] = new StringBuilder();// 保留第二个ip和子网掩码交的结果
        for (int i = 0;i<2;i++){
            String[] strNums = strings[i].split("\\."); // 第i个ip地址
            for (int j = 0;j<4;j++){
                String res =binaryToDecimal(Integer.parseInt(strNums[j]));
                String test = binaryToDecimal(Integer.parseInt(testStr[j]));
                for (int k = 0;k<res.length();k++){
                    if (res.charAt(k) ==  '1' && test.charAt(k) == '1')
                        str1[i].append("1");
                    else
                        str1[i].append("0");
                }
                str1[i].append(".");
            }
        }
        String[] s = str1[0].toString().split("\\.");
        StringBuilder res = new StringBuilder();
        for (int i = 0;i<4;i++){
            res.append(BinaryToDecimal(Integer.parseInt(s[i])));
            if (i<3)
                res.append(".");
        }
        if (str1[0].toString().equals(str1[1].toString())){
            System.out.println(1 + " " + res.toString());
        } else {
            System.out.println(0 + " " + res.toString());
        }
    }

    /**
     * 十进制转换为二进制
     * @param n
     * @return
     */
    public static String binaryToDecimal(int n){
        String str = "";
        while (n!=0){
            str = n%2+str;
            n=n/2;
        }
        // 补齐8位
        while (str.length()!=8){
            str = "0" + str;
        }
        return str;
    }

    /**
     * 二进制转十进制
     * @param binaryNumber
     * @return
     */
    public static int BinaryToDecimal(int binaryNumber){
        int decimal = 0;
        int p = 0;
        while (true){
            if (binaryNumber == 0)
                break;
            else {
                int temp = binaryNumber % 10;
                decimal+=temp*Math.pow(2,p);
                binaryNumber = binaryNumber/10;
                p++;
            }
        }
        return decimal;
    }

}


