package cn.practice.basis.grammar._03_Collection.CollectionTest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionDemo1 {
    public static void main(String[] args) {
        Collection collection = new ArrayList();
        collection.add("hello");
        collection.add("134");
        collection.add(123);
        collection.add(false);

        System.out.println(collection);

        System.out.println("迭代器");
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
