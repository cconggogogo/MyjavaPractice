package cn.practice.BZhan._09_Annotation;

import cn.practice.BZhan._08_Enum.Color;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 自定义注解(编写注解)
 * RetentionPolicy.RUNTIME:运行时期检查
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    public String name();
    public int age() default 20; // 默认值，在调用的时候可以不给默认值了
    public String[] likes(); // 数组类型
    public Color color(); // 注解类型
}
