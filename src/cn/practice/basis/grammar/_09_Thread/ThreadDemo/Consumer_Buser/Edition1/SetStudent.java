package cn.practice.basis.grammar._09_Thread.ThreadDemo.Consumer_Buser.Edition1;


import cn.practice.basis.grammar._09_Thread.ThreadDemo.Consumer_Buser.Student;

public class SetStudent extends Thread{
    Student student;

    public SetStudent(Student student){
        this.student = student;
    }

    @Override
    public void run() {
        student.setAge(20);
        student.setName("ZHANG三");
    }
}
