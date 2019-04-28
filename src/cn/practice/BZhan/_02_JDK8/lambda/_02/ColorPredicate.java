package cn.practice.BZhan._02_JDK8.lambda._02;

import cn.practice.BZhan._02_JDK8.lambda._01.Product;

/**
 * 如果想要筛选颜色为红色的商品，定义一个颜色过滤类
 */
public class ColorPredicate implements MyPredicate<Product> {
    private static final String RED = "红色";
    @Override
    public boolean test(Product product) {
        return RED.equals(product.getColor());
    }
}
