package cn.practice.BZhan._02_JDK8.lambda._03;

import cn.practice.BZhan._02_JDK8.lambda._01.Product;
import cn.practice.BZhan._02_JDK8.lambda._02.MyPredicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public List<Product> filterProductByPredicate(List<Product> lists, MyPredicate<Product> mp){
        List<Product> products = new ArrayList<>();
        for (Product product: products){
            if (mp.test(product)){
                products.add(product);
            }
        }
        return products;
    }

    /**
     * 通过匿名内部类改进
     */
    @org.junit.Test
    public void test1(){
        List<Product> lists = new ArrayList<>();
        filterProductByPredicate(lists, new MyPredicate<Product>() {
            @Override
            public boolean test(Product product) {
                return "红色".equals(product.getColor());
            }
        });
    }

    /**
     * 通过lambda改进
     */
    @org.junit.Test
    public void test2(){
        Product product1 = new Product("红色",454.6);
        Product product2 = new Product("白色",454.6);
        Product product3 = new Product("红色",454.6);
        List<Product> lists = Arrays.asList(product1, product2, product3);
        System.out.println(lists);
        List<Product> products = filterProductByPredicate(lists, (p) -> "红色".equals(p.getColor()));
        System.out.println("products: " + products);
        for (Product product: products){
            System.out.println(product);
        }
    }
}
