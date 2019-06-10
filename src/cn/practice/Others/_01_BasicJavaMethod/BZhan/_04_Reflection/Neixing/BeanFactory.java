package cn.practice.Others._01_BasicJavaMethod.BZhan._04_Reflection.Neixing;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class BeanFactory {
    private static Properties prop = new Properties();
    // 使用静态代码块读取配置文件
    static {
        InputStream in = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream("cn/practice/Others/_01_BasicJavaMethod/BZhan/_04_Reflection/Neixing/config.properities");
        try {
            // 加载配置文件信息到流中
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 获取一个Bean
     */
    public static Object getBean(String name){
        Object bean = null;
        String beanName = prop.getProperty(name);
        try {
            Class<?> aClass = Class.forName(beanName);
            bean = aClass.newInstance();
            // 通过类信息获取javabean的描述信息
            BeanInfo beanInfo = Introspector.getBeanInfo(aClass);
            // 通过javabean的描述信息，获取该类的所有属性描述器
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (int i = 0; i<propertyDescriptors.length;i++){
                String name1 = propertyDescriptors[i].getName();
                Method writeMethod = propertyDescriptors[i].getWriteMethod();
                if ("username".equals(name1)){
                    // 调用属性的set方法
                    writeMethod.invoke(bean,prop.getProperty("bean.username"));
                } else if ("password".equals(name1)){
                    writeMethod.invoke(bean,prop.getProperty("bean.password"));
                } else if ("url".equals(name1)){
                    writeMethod.invoke(bean,prop.getProperty("bean.url"));
                }
            }
        } catch (ClassNotFoundException | IntrospectionException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
        return bean;
    }
}
