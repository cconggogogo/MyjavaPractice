package cn.practice.BZhan._02_JDK8.lambda.practice._02;

import java.util.Arrays;
import java.util.List;

public class Test {

    // _02_Thread
    @org.junit.Test
    public void test(){
        // 原来的写法
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello runnable");
            }
        });
        // ----------------------------

        // 线程结合lambda的写法
        new Thread(
                () -> System.out.println("runnable")
        ).start();
    }

    // 数组
    @org.junit.Test
    public void test2(){
        // 遍历数组
        List<Integer> lists = Arrays.asList(1,2,3,4,5,6,7);
        // 方法一
        for (Integer n : lists){
            System.out.println(n);
        }
        System.out.println("===================");

        // forEach方法
        lists.forEach(
                n -> System.out.println(n)
        );

        // foEach方法二
        lists.forEach(System.out::println);
    }

}
