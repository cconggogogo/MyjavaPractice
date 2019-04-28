package cn.practice.basis.grammar._09_Thread.ThreadDemo.SellTicket;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TicketsRuannble2 implements Runnable{
    private int tickets = 100;

    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                if (tickets>0){
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + "正在出售第" + tickets-- + "张票");
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
