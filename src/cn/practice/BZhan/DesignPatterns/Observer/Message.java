package cn.practice.BZhan.DesignPatterns.Observer;

import java.util.ArrayList;
import java.util.List;

public class Message implements MessageSubject{
    // 维护的所有的观察者
    List<Observer> list = new ArrayList<>();
    String message;

    public void setMessage(String message) {
        this.message = message;
        notifyObservers();
    }

    @Override
    public void registObserver(Observer observer) {
        list.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        list.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (int i = 0;i<list.size();i++){
            Observer observer = list.get(i);
            observer.update(message);
        }
    }
}
