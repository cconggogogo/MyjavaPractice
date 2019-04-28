package cn.practice.BZhan.DesignPatterns.Iteartor;

/**
 * 容器接口
 */
public interface MyList {
    void add(Object e);
    Object get(int index);
    Iterator iterator();
    int getSize();
}
