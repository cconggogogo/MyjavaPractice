package cn.practice.Others._01_BasicJavaMethod.demo;

public class Teacher {
    public void check(int score) {
        if (score < 0 || score > 100){
           throw new MyException("成绩有问题");
        }else {
            System.out.println("成绩没问题");
        }
    }
}
