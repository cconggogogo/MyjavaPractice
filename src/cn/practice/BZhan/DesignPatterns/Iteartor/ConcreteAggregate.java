package cn.practice.BZhan.DesignPatterns.Iteartor;

/**
 * 容器的具体实现类
 */
public class ConcreteAggregate implements MyList{
    private Object[] elements;
    private int size;
    private int index;
    public ConcreteAggregate(){
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
        return new ConcreteIterator(this);
    }

    @Override
    public int getSize() {
        return size;
    }
}
