package cn.practice.Others._01_BasicJavaMethod;
abstract class Inter{
    void method(){}
}
class InterImpl{
    public Inter method(){
        return new Inter() {
            @Override
            void method() {
                System.out.println("好好学习");
            }
        };
    }
}
public class Test {
    public static void main(String[] args) {
        new InterImpl().method().method();
    }
}
