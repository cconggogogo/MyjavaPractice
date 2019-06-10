package cn.practice.DesignPatterns.Observer;



/**
 * 被观察者接口(主题)
 */
public interface Subject {
    // 注册观察者
    public void registObserver(Observer observer);

    // 移出观察者
    public void removeObserver(Observer observer);

    // 通知所有的观察者
    public void notifyObservers();
}
