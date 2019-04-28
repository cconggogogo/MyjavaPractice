package cn.practice.BZhan.DesignPatterns.Adapter._01;

public class Adapter implements PowerA{
    private PowerB powerB;

    public Adapter(PowerB powerB){
        this.powerB = powerB;
    }

    @Override
    public void insert() {
        powerB.connect();
    }
}
