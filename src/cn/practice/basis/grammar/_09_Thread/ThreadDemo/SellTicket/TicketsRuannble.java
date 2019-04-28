package cn.practice.basis.grammar._09_Thread.ThreadDemo.SellTicket;

public class TicketsRuannble implements Runnable{
    private int tickets = 100;

    Object obj = new Object();

    @Override
    public void run() {
        while (true) {
           if (tickets>0) {
               synchronized (obj) {
                   try {
                       Thread.sleep(1000);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   System.out.println(Thread.currentThread().getName() + "正在出售第" + tickets-- + "张票");
               }
           }
        }
    }
}
