package cn.practice.Others._01_BasicJavaMethod._10_Pattern.PatternDemo.Test;

public class StudentDaoImpl implements StudentDao{
    @Override
    public void login() {
        System.out.println("登陆功能");
    }

    @Override
    public void regist() {
        System.out.println("注册功能");
    }
}
