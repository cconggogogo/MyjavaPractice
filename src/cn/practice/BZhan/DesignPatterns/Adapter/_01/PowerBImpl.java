package cn.practice.BZhan.DesignPatterns.Adapter._01;

public class PowerBImpl implements PowerB{
    @Override
    public void connect() {
        System.out.println("电影B工作");
    }
}
