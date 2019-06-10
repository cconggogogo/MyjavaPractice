package cn.practice.DesignPatterns.Iteartor;

/**
 * 迭代器的具体实现类
 */
public class IteratorImpl implements Iterator{
    private MyList list = null; // 容器
    private int index;
    public IteratorImpl(MyList list){
        this.list = list;
    }
    @Override
    public boolean hasNext() {
        if(index >=list.getSize())
            return false;
        else
            return true;
    }

    @Override
    public Object next() {
        Object obj = list.get(index);
        index++;
        return obj;
    }
}
