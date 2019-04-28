package cn.practice.basis.grammar._09_Thread.ThreadDemo.SellTicket;

public class TicketsThread extends Thread{
    private static int tickets = 100;

    public TicketsThread(String name){
        super(name);
    }

    @Override
    public void run() {
        while (true) {
            if (tickets> 0) {
                System.out.println(getName() + "正在出售第" + (tickets--) + "张票");
            }
        }
    }
}
