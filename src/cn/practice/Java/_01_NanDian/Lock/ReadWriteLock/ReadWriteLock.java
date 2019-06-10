package cn.practice.Java._01_NanDian.Lock.ReadWriteLock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Mycache{
    private volatile Map<String,Object> map = new HashMap<>();
    private Lock lock = new ReentrantLock();

    public void put(String key, Object value){
        System.out.println(Thread.currentThread().getName() + "\t正在写入:" +key);
        try {
            TimeUnit.MICROSECONDS.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        map.put(key,value);
        System.out.println(Thread.currentThread().getName()+"\t写入完成");
    }

    public void get(String key){
        System.out.println(Thread.currentThread().getName()+"\t正在读取：");
        try {
            TimeUnit.MICROSECONDS.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Object result = map.get(key);
        System.out.println(Thread.currentThread().getName()+"\t读取完成" + result);
    }
}
public class ReadWriteLock {
    public static void main(String[] args) {
        Mycache mycache = new Mycache();
        for (int i=1;i<=5;i++){
            final int tempInt =1;
            new Thread(() -> {
                mycache.put(tempInt+"",tempInt+"");
            },String.valueOf(i)).start();
        }
        for (int i=1;i<=5;i++){
            final int tempInt =i;
            new Thread(() -> {
                mycache.get(tempInt+"");
            },String.valueOf(i)).start();
        }
    }
}
