package cn.practice.Others._01_BasicJavaMethod._06_Exception.ExceptionTest;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test1 {
    public static void main(String[] args) {
//        test1();
//        test2();
        test3();
    }

    private static void test3() {
        String date = "2015-1-12";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


        try {
            Date date1 = sdf.parse(date);
            System.out.println(date1);
        } catch (ParseException e) {
            System.out.println("日期解析异常");
        } finally {
            System.out.println("这条语句一定会被执行");
        }
        System.out.println("over");
    }

    public static void test2() {
        int a= 10;
        int b = 0;
        int[] arr = {1,2,3};
        try {
            System.out.println(a / b);
            System.out.println(arr[3]);
        } catch (ArrayIndexOutOfBoundsException | ArithmeticException e) {
            System.out.println("出错了");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void test1() {
        int a= 10;
        int b = 0;
        int[] arr = {1,2,3};
        try {
//            System.out.println(a/b);
            System.out.println(arr[3]);
        } catch (ArithmeticException e){
            System.out.println("除数不能为0");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("数组越界");
        } catch (Exception e) {
            System.out.println("其他问题");
        }
    }
}
