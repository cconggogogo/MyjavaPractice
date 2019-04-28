package cn.practice.particularClassDemo.LinkedList;

public class Test {
    public static void main(String[] args) {
        Link link = new LinkImpl();
        link.add("hello");
        link.add("world");
        link.add("java");
        link.add("suxue");
        link.printLink();
        System.out.println("==================");
        System.out.println("contains: " + link.contains("hello"));
        System.out.println("get:"+link.get(2));
        link.remove(1);
        System.out.println("===============");
        link.printLink();

    }
}
