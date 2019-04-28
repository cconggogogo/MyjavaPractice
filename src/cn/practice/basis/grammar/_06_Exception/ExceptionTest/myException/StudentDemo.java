package cn.practice.basis.grammar._06_Exception.ExceptionTest.myException;

import java.util.Scanner;

public class StudentDemo {
    public static void main(String[] args) {
        System.out.println("请输入成绩");
        Scanner scanner = new Scanner(System.in);
        int score = scanner.nextInt();
        Teacher teacher = new Teacher();
        try {
            teacher.check(score);
        } catch (MyExcetion myExcetion) {
            myExcetion.printStackTrace();
        }
    }
}
