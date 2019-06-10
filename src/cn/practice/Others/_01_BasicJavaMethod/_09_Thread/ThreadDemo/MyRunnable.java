package cn.practice.Others._01_BasicJavaMethod._09_Thread.ThreadDemo;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int x= 0; x<100; x++) {
            System.out.println(Thread.currentThread().getName() + x);
        }
    }
}
