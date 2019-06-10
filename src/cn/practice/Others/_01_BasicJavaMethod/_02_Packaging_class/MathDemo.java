package cn.practice.Others._01_BasicJavaMethod._02_Packaging_class;

import java.util.Scanner;

public class MathDemo {
    public static void main(String[] args) {
        System.out.println("输入范围");
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt();
        int end = scanner.nextInt();

        for (int x=0; x<100; x++) {
            System.out.println("随机数为: " + getRandom(start, end));
        }
    }

    public static int getRandom(int start, int end) {
        return (int)(Math.random()*(end - start -1) ) +start;
    }
}
