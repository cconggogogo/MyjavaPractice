package cn.practice.Others._01_BasicJavaMethod.BZhan._02_JDK8.lambda._02;

import cn.practice.Others._01_BasicJavaMethod.BZhan._02_JDK8.lambda._01.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用设计模式
 */
public class Test {
    public List<Product> filterProductByPredicate(List<Product> lists,MyPredicate<Product> mp){
        List<Product> products = new ArrayList<>();
        for (Product product: lists){
            if (mp.test(product)){
                products.add(product);
            }
        }
        return products;
    }
}
