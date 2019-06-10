package cn.practice.Others._01_BasicJavaMethod._11_Thread.CallableDemo.test1;

import java.util.concurrent.*;

public class MyCallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(2);

        Future<Integer> f1 = pool.submit(new MyCallable(100));
        Future<Integer> f2 = pool.submit(new MyCallable(200));

        Integer res1 = f1.get();
        Integer res2 = f2.get();

        System.out.println("res1: " + res1);

        System.out.println("res2: " + res2);


    }
}
