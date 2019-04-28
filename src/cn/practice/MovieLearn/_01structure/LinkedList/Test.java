package cn.practice.MovieLearn._01structure.LinkedList;

public class Test {
    public static void main(String[] args) {
        NodeManager nm = new NodeManager();
        nm.add(3);
        nm.add(33);
        nm.add(34);
        nm.add(35);
        nm.add(63);
        nm.add(73);
        nm.print();

        System.out.println("find: " + nm.find(73));
        nm.update(33,34);
        System.out.println("------------");

        nm.print(); nm.update(34,35);
        System.out.println("------------");
        nm.print();

        System.out.println("------------");
        nm.insert(1,244);
        nm.print();

        System.out.println("------------");
        nm.del(244);
        nm.print();

    }
}
