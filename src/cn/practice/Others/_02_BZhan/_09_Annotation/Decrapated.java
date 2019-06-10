package cn.practice.Others._02_BZhan._09_Annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Target;

@Documented // 用于生成文档
@Inherited // 子类可以继承父类的注解
// 用于该注解的作用范围：类，方法，局部变量，包，构造方法...
@Target(value = {ElementType.CONSTRUCTOR,ElementType.ANNOTATION_TYPE,ElementType.FIELD}) // 限
public @interface Decrapated {
}
