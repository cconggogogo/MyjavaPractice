package cn.practice.Interview.douyu;

/**
 * null可以被强制类型转换成任意类型的对象，通过这样的方式可以执行对象的静态方法，但如果方法不是静态方法的话，由于null对象并没有被实例化（分配空间），因而运行时会报空指针错误。
 *
 * 总结：
 *
 * 1: null可以转化为任何类型
 *
 * 2: private 只是权限声明
 *
 * 2：static静态关键字 仅仅意味着可以不用实例化这个类 
 *
 *    通过类名.方法名就可以访问 
 *
 *    当然也可以通过实例化类的对象后 通过对象.方法名 
 *
 *    但是不能通过this关键字，因为this是指本实例中的方法被static声明的方法属于类的方法
 */
public class TestClass {
    private static void testMethod(){
        System.out.println("testMethod");
    }

    public static void main(String[] args) {
        ((TestClass)null).testMethod();
    }
}
/**
 执行结果：运行正常，输出testMethod
 */