package cn.practice.DesignPatterns.Iteartor;

/**
 * 容器的具体实现类
 */
public class MyListImpl implements MyList{
    private Object[] elements;
    private int size;
    private int index;
    public MyListImpl(){
        elements = new Object[100];
    }
    @Override
    public void add(Object e) {
        elements[index++]=e;
        size++;
    }

    @Override
    public Object get(int index) {
        return elements[index];
    }

    @Override
    public Iterator iterator() {
        return new IteratorImpl(this);
    }

    @Override
    public int getSize() {
        return size;
    }
}
