package cn.practice.Others._01_BasicJavaMethod._09_Thread.ThreadDemo.Consumer_Buser.Edition2;

import cn.practice.Others._01_BasicJavaMethod._09_Thread.ThreadDemo.Consumer_Buser.Student;

public class GetStudent implements Runnable{
    Student student;

    public GetStudent(Student student) {
        this.student = student;
    }

    @Override
    public void run() {
        synchronized (student) {
            System.out.println(student.getName() + "=" +student.getAge());
        }
    }
}
