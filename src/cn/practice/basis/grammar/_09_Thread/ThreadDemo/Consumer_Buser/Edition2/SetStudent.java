package cn.practice.basis.grammar._09_Thread.ThreadDemo.Consumer_Buser.Edition2;


import cn.practice.basis.grammar._09_Thread.ThreadDemo.Consumer_Buser.Student;

public class SetStudent implements Runnable{
    Student student;

    public SetStudent(Student student){
        this.student = student;
    }

    int index = 0;

    @Override
    public void run() {
        synchronized (student) {
            if (index%2 == 0) {
                index++;
                student.setAge(20);
                student.setName("ZHANG三");
            } else {
                index++;
                student.setAge(32);
                student.setName("lisi");
            }
        }
    }
}
