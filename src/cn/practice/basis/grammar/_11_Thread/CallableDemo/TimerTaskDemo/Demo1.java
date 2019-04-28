package cn.practice.basis.grammar._11_Thread.CallableDemo.TimerTaskDemo;

import java.util.Timer;
import java.util.TimerTask;

public class Demo1 {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new MyTimerTask(timer),1000,1000);
    }

}

class MyTimerTask extends TimerTask{

    private Timer timer;

    public MyTimerTask(Timer timer){
        this.timer = timer;
    }

    public MyTimerTask(){}

    @Override
    public void run() {
        System.out.println("爆炸了");
//        timer.cancel();
    }
}

