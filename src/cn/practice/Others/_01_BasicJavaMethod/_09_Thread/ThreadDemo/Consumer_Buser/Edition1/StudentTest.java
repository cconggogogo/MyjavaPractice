package cn.practice.Others._01_BasicJavaMethod._09_Thread.ThreadDemo.Consumer_Buser.Edition1;


import cn.practice.Others._01_BasicJavaMethod._09_Thread.ThreadDemo.Consumer_Buser.Student;

public class StudentTest {
    public static void main(String[] args) {
        Student s = new Student();
        SetStudent ss = new SetStudent(s);
        GetStudent gs = new GetStudent(s);

        ss.start();
        gs.start();

    }
}
