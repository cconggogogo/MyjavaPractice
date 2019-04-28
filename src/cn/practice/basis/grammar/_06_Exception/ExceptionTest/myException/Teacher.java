package cn.practice.basis.grammar._06_Exception.ExceptionTest.myException;

public class Teacher {
    public void check(int score) throws MyExcetion{
        if (score <0 || score >100)
            throw new MyExcetion("成绩不符合要求");
        else
            System.out.println("成绩没问题");
    }
}
