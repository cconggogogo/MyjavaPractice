package cn.practice.Others._01_BasicJavaMethod._09_Thread.ThreadDemo.SellTicket;

public class SellTicketsRuannable {
    public static void main(String[] args) {
//        test1();
        test2();
    }

    public static void test2() {
        TicketsRuannble2 tr = new TicketsRuannble2();
        Thread t1 = new Thread(tr,"窗口一");
        Thread t2 = new Thread(tr,"窗口二");
        Thread t3 = new Thread(tr, "窗口三");

        t1.start();
        t2.start();
        t3.start();
    }
    public static void test1() {
        TicketsRuannble tr = new TicketsRuannble();
        Thread t1 = new Thread(tr,"窗口一");
        Thread t2 = new Thread(tr,"窗口二");
        Thread t3 = new Thread(tr, "窗口三");

        t1.start();
        t2.start();
        t3.start();
    }
}
