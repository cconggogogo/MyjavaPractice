package cn.practice.Others._01_BasicJavaMethod.BZhan._02_JDK8.lambda.practice._01;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * lambda:
 * Lambda 表达式是一种匿名函数;
 *
 * 当某个方法只使用一次，而且定义很简短，
 * 使用这种速记替代之尤其有效，
 * 这样，你就不必在类中费力写声明与方法了;
 *
 *  Lambda 表达式通常使用 (argument) -> (body) 语法书写
 *
 *
 */
public class Test {
    @org.junit.Test
    public void test(){
        /**
         * 例子：
         * (int a, int b) -> {  return a + b; };
         *
         *         () -> System.out.println("Hello World");
         *
         *         (String s) -> { System.out.println(s); }
         *
         *         () -> 42
         *
         *         () -> { return 3.1415 };
         *
         *
         *  lambda表达式的结构：
         *  让我们了解一下 Lambda 表达式的结构。
         * 一个 Lambda 表达式可以有零个或多个参数
         * 参数的类型既可以明确声明，也可以根据上下文来推断。例如：(int a)与(a)效果相同
         * 所有参数需包含在圆括号内，参数之间用逗号相隔。例如：(a, b) 或 (int a, int b) 或 (String a, int b, float c)
         * 空圆括号代表参数集为空。例如：() -> 42
         * 当只有一个参数，且其类型可推导时，圆括号（）可省略。例如：a -> return a*a
         * Lambda 表达式的主体可包含零条或多条语句
         * 如果 Lambda 表达式的主体只有一条语句，花括号{}可省略。匿名函数的返回类型与该主体表达式一致
         * 如果 Lambda 表达式的主体包含一条以上语句，则表达式必须包含在花括号{}中（形成代码块）。匿名函数的返回类型与代码块的返回类型一致，若没有返回则为空
         *
         *
         * 什么是函数式接口
         * 在 Java 中，Marker（标记）类型的接口是一种没有方法或属性声明的接口，简单地说，marker 接口是空接口。相似地，函数式接口是只包含一个抽象方法声明的接口。
         *
         * java.lang.Runnable 就是一种函数式接口，在 Runnable 接口中只声明了一个方法 void run()，相似地，ActionListener 接口也是一种函数式接口，我们使用匿名内部类来实例化函数式接口的对象，有了 Lambda 表达式，这一方式可以得到简化。
         *
         * 每个 Lambda 表达式都能隐式地赋值给函数式接口，例如，我们可以通过 Lambda 表达式创建 Runnable 接口的引用。
         */

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("method");
            }
        };

        // 效果同上
        Runnable r = () -> System.out.println("hello worulf");

        // ----------------------------------------

        /**
         * 因此，在上面的代码中，编译器会自动推断：根据线程类的构造函数签名 public Thread(Runnable r) { }，
         * 将该 Lambda 表达式赋给 Runnable 接口。
         */
        new Thread(
                () -> System.out.println("hwllo")
        ).start();

        //----------------------------------------------

        // 以下是一些 Lambda 表达式及其函数式接口：

        Consumer<Integer>  c = x -> { System.out.println(x); };
        BiConsumer<Integer,String> b =(x,y) -> System.out.println(x + "--" + y);
        // 断言
        Predicate<String> p = s -> s == null;
    }

    @org.junit.Test
    public void test2(){
        /**
         * @FunctionalInterface 是 Java 8 新加入的一种接口，
         * 用于指明该接口类型声明是根据 Java 语言规范定义的函数式接口。
         * Java 8 还声明了一些 Lambda 表达式可以使用的函数式接口，
         * 当你注释的接口不是有效的函数式接口时，
         * 可以使用 @FunctionalInterface 解决编译层面的错误。
         */
    }
}
