package cn.practice.BZhan.DesignPatterns.Adapter._01;

public class PowerAImpl implements PowerA{
    @Override
    public void insert() {
        System.out.println("电源A连接");
    }
}
