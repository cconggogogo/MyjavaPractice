package cn.practice.basis.grammar._09_Thread.ThreadDemo.Consumer_Buser.Edition1;

import cn.practice.basis.grammar._09_Thread.ThreadDemo.Consumer_Buser.Student;

public class GetStudent extends Thread{
    Student student;

    public GetStudent(Student student) {
        this.student = student;
    }

    @Override
    public void run() {
        System.out.println(student.getName() + "=" +student.getAge());
    }
}
