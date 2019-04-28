package cn.practice.MovieLearn.jdkNews._02lambda;

public class Test1 {
    public static void main(String[] args) {
        // 没有参数时使用
        Animal animal = () -> {
            System.out.println("hahaha");
        };
        animal.eat();

        // 带参数时使用,参数的类型可以省略
        Demo demo = (s) -> {
            System.out.println(s + "haha");
        };
        demo.eat("nizaima");

        // 返回值，只有一句实现语句
        Demo2 demo2 = (s) -> 23 + s;
        System.out.println(demo2.eat("haha"));

        // 返回值，多句实现语句
        Demo3 demo3 = (s) -> {
            System.out.println("wo来了");
            return s + "hahahadjfo";
        };
        demo3.eat("nizohf");
    }
}
// 只有一个抽象方法的接口
interface Animal{
    public abstract void eat();
}
interface Demo{
    public abstract void eat(String name);
}
interface Demo2{
    public abstract String eat(String name);
}

interface Demo3{
    public abstract String eat(String name);
}
