package cn.practice.DesignPatterns.Iteartor;

public class Test {
    @org.junit.Test
    public void test(){
        MyList myList = new MyListImpl();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        Iterator iterator = myList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
