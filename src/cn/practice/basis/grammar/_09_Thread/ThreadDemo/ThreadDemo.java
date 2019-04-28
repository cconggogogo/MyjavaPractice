package cn.practice.basis.grammar._09_Thread.ThreadDemo;

public class ThreadDemo {
    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
//        test4();
//        test5();
        test6();
    }

    private static void test6() {
        System.out.println("yield: 让线程一人执行依次");
        MyThread my1 = new MyThread("liyuan");
        MyThread my2 = new MyThread("lishimin");
        my1.start();
        my2.start();
    }

    private static void test5() {
        System.out.println("stop: 超过多长时间没有醒过来就彻底结束该线程(stop,不会抛错)，interrupt（会抛错）");
        MyThread my1 = new MyThread("liyuan");
        my1.start();
        try {
            Thread.sleep(3000);
//            my1.interrupt();
            my1.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void test4() {
        System.out.println("sleep: 休眠线程，静态方法");
        MyThread my1 = new MyThread("liyuan");
        MyThread my2 = new MyThread("lishimin");
        my1.start();
        my2.start();
    }
    public static void test3() {
        System.out.println("join: 等待该线程终止");
        MyThread my1 = new MyThread("liyuan");
        MyThread my2 = new MyThread("lishimin");
        MyThread my3 = new MyThread("liyuanba");
        my1.start();
        try {
            my1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        my2.start();
        my3.start();
    }
    public static void test2() {
        System.out.println("测试守护线程: 主公死了自己才能死");
        MyThread my1 = new MyThread("zhangfei");
        MyThread my2 = new MyThread("guanyu");
        my1.setDaemon(true);
        my2.setDaemon(true);
        my1.start();
        my2.start();

        Thread.currentThread().setName("刘备");
        for (int x= 0;x<5; x++) {
            System.out.println(Thread.currentThread().getName() + x);
        }
    }

    public static void test1() {
        MyThread my1 = new MyThread("张三");
        MyThread my2 = new MyThread("clj");
//        my1.run();
//        my2.run();
        my1.start();
        my2.start();
        System.out.println("主程序的线程名字" + Thread.currentThread().getName());
    }
}
