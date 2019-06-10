package cn.practice.Others._01_BasicJavaMethod._09_Thread.ThreadDemo.DieLock;

public class MyLockDemo extends Thread{
    private boolean flag;

    public MyLockDemo(boolean flag){
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag) {
            synchronized (MyLock.objA){
                System.out.println("ifOjbA");
                synchronized (MyLock.objB) {
                    System.out.println("ifObjB");
                }
            }
        } else {
            synchronized (MyLock.objB){
                System.out.println("elseObjB");
                synchronized (MyLock.objA) {
                    System.out.println("elseObjA");
                }
            }
        }
    }
}
