package cn.practice.Others._01_BasicJavaMethod._09_Thread.ThreadDemo.DieLock;

public class MyLockTest {
    public static void main(String[] args) {
        MyLockDemo m1 = new MyLockDemo(true);
        MyLockDemo m2 = new MyLockDemo(false);

        m1.start();
        m2.start();


    }
}
