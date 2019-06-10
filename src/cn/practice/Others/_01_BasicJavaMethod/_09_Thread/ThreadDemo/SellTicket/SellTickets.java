package cn.practice.Others._01_BasicJavaMethod._09_Thread.ThreadDemo.SellTicket;

public class SellTickets {
    public static void main(String[] args) {
        TicketsThread t1 = new TicketsThread("3号");
        TicketsThread t2 = new TicketsThread("2号");
        TicketsThread t3 = new TicketsThread("3号");

        t1.start();
        t2.start();
        t3.start();
    }
}
