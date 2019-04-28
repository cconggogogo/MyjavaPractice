package cn.practice.basis.grammar._02_Packaging_class;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarDemo {
    public static void main(String[] args) {
        System.out.println("日历测试");
        // 计算2月有多少天
        System.out.println("请输入月份，计算2月有多少天");
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();

        Calendar calendar = Calendar.getInstance();
        calendar.set(year,2,1);

        calendar.add(Calendar.DATE, -1);

        System.out.println(year + "年2月有" + calendar.get(Calendar.DATE) + "天");

    }
}
