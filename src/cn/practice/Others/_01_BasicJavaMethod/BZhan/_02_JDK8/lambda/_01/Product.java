package cn.practice.Others._01_BasicJavaMethod.BZhan._02_JDK8.lambda._01;

public class Product {
    private String color;
    private double price;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product(String color, double price) {
        this.color = color;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
}
