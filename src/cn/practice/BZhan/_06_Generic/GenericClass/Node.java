package cn.practice.BZhan._06_Generic.GenericClass;

/**
 * 泛型类的使用
 */
public class Node<T> {
    private T data;

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
