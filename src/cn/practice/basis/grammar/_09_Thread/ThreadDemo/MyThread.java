package cn.practice.basis.grammar._09_Thread.ThreadDemo;

public class MyThread extends Thread{

    private  String name;

    public MyThread(String name) {
        super(name);
    }
    @Override
    public void run() {
        for (int x= 0; x<100; x++) {
            System.out.println(this.getName() + x);

//            try {
//                Thread.sleep(10000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

            Thread.yield();
        }
    }
}
