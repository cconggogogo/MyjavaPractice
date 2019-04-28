package cn.practice.particularClassDemo.LinkedList;

public interface Link {
    void add(Object obj);
    boolean remove(int index);
    boolean set(int index, Object obj);
    Object get(int index);
    void printLink();
    Object[] toArray();
    int getSize();
    void clear();
    int contains(Object obj);
}
