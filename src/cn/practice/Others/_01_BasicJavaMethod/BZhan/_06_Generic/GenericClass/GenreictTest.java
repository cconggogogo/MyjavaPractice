package cn.practice.Others._01_BasicJavaMethod.BZhan._06_Generic.GenericClass;

import org.junit.Test;

/**
 * T是参数化类型
 * 泛型只在编译器有用，运行期会被擦出
 */
public class GenreictTest {
    @Test
    public void test(){
        Node<Number> node = new Node<>(13);
    }
}

