package cn.practice.Others._01_BasicJavaMethod._02_Packaging_class;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateDemo {
    public static void main(String[] args) throws ParseException {
        // 计算出生的天数
        System.out.println("请输入你出生日期");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(line);

        long getTime = date.getTime();
        long currentTime = System.currentTimeMillis();

        long difference = currentTime - getTime;

        System.out.println("你来到这个世上已经" + difference/1000/60/60/24 + "天了");


    }
}
