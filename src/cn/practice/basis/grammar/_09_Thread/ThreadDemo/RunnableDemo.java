package cn.practice.basis.grammar._09_Thread.ThreadDemo;

public class RunnableDemo {
    public static void main(String[] args) {
//        test1();
    }

    public static void test1() {
        MyRunnable mr = new MyRunnable();

        Thread t1 = new Thread(mr,"hyy");
        Thread t2 = new Thread(mr, "clj");
        t1.start();
        t2.start();
    }
}
