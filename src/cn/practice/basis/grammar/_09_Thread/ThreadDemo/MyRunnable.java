package cn.practice.basis.grammar._09_Thread.ThreadDemo;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int x= 0; x<100; x++) {
            System.out.println(Thread.currentThread().getName() + x);
        }
    }
}
