package cn.practice.BZhan._02_JDK8.lambda._01;

import java.util.ArrayList;
import java.util.List;

/**
 * 这样一个场景，在商城浏览商品信息时，经常会有条件的进行筛选浏览，
 * 例如要选颜色为红色的、价格小于8000千的….
 */

/**
 * 发现实际上这些过滤方法的核心就只有if语句中的条件判断，
 * 其他均为模版代码，每次变更一下需求，都需要新增一个方法，然后复制黏贴，
 * 假设这个过滤方法有几百行，那么这样的做法难免笨拙了一点。如何进行优化呢？
 */
public class Filter {
    public List<Product> filterProductByPrice(List<Product> lists){
        List<Product> products = new ArrayList<>();
        for (Product product: lists){
            if (product.getPrice() < 8000){
                products.add(product);
            }
        }
        return products;
    }

    public List<Product> filterProductByColor(List<Product> lists){
        List<Product> products = new ArrayList<>();
        for (Product product: lists){
            if ("红色".equals(product.getColor())){
                products.add(product);
            }
        }
        return products;
    }
}
