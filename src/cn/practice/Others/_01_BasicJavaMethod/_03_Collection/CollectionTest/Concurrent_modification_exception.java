package cn.practice.Others._01_BasicJavaMethod._03_Collection.CollectionTest;

import java.util.*;

public class Concurrent_modification_exception {
    public static void main(String[] args) {
        // 并发修改异常
        List list = new ArrayList();
        list.add("hello");
        list.add("world");
        list.add(123);
        list.add(false);

        // 普通迭代器遍历集合
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();

        // List特殊的迭代器遍历集合
        System.out.println("从前往后");
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }
        System.out.println();

        System.out.println("从后往前");
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }
        System.out.println();

        System.out.println("for循环遍历");
        for (int i = 0; i<list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println();

        System.out.println("并发修改异常_迭代器遍历迭代器修改元素");
        while (listIterator.hasNext()) {
            if (listIterator.next().equals("hello")){
                listIterator.add("hello1");
            }
        }
        System.out.println("newList: " + list);

        System.out.println("并发修改异常_集合遍历元素集合修改元素");
        for (int y=0; y<list.size(); y++) {
            if (list.get(y).equals("world")){
                list.add("world1");
            }
        }
        System.out.println("newList2: " + list);
        System.out.println();

        System.out.println("测试vector集合的迭代器");
        VectorIteratorDemo();
    }

    public static void VectorIteratorDemo() {
        Vector vector = new Vector();
        vector.add("hello");
        vector.add("world");
        vector.add("123");
        vector.add(234);
        vector.add(false);

        // bianli
        System.out.println("迭代器遍历方式");
        Enumeration en = vector.elements();
        while (en.hasMoreElements()) {
            System.out.println(en.nextElement());
        }
        System.out.println();

        // for循环遍历方式
        System.out.println("for循环遍历方式");
        for (int i=0; i<vector.size(); i++) {
            System.out.println(vector.elementAt(i));
        }
    }
}
