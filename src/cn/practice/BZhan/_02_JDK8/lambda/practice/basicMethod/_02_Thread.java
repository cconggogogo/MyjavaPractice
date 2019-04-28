package cn.practice.BZhan._02_JDK8.lambda.practice.basicMethod;

import org.junit.Test;

public class _02_Thread {
    @Test
    public void test(){
        new Thread(
                () -> System.out.println("runnbale")
        ).start();

        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("runnbale");
            }
        };

        Runnable rr = () -> System.out.println("runnbale");
    }
}
