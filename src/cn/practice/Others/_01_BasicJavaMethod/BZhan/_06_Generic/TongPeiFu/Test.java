package cn.practice.Others._01_BasicJavaMethod.BZhan._06_Generic.TongPeiFu;

import cn.practice.Others._01_BasicJavaMethod.BZhan._06_Generic.GenericClass.Node;

public class Test {
    @org.junit.Test
    public void test(){
        Node<Number> node = new Node<>(12);
        Node<Integer> node1 = new Node<>(3434);
        getData(node);
        System.out.println("---");
        getData(node1);
    }

    /**
     * 使用通配符定义泛型的类型，
     * 此时不能修改
     * ? ：所有的
     * ？ extends：下限
     * ? super:上限
     * @param node
     */
    public static void getData(Node<?> node){
        System.out.println(node.getData());
    }
}
