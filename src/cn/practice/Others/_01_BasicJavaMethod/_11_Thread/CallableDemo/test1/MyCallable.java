package cn.practice.Others._01_BasicJavaMethod._11_Thread.CallableDemo.test1;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    private Integer number;

    public MyCallable(Integer number) {
        this.number = number;
    }

    @Override
    public Integer call(){
        int sum = 0;
        for (int x = 0; x< number; x++) {
            sum+=x;
        }
        return sum;
    }
}
