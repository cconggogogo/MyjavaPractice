package cn.practice.Algorithm.Leetcode.before.Array;

public class Test7 {

    public int Fibonacci(int n) {
        int i,temp1,temp2;
        if(n<=0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        temp1=0;
        temp2=1;
        for(i=1;i<=n/2;i++){
            temp1+=temp2;
            temp2+=temp1;
        }
        if(n%2==0){
            return temp1;
        }
        else{
            return temp2;
        }
    }

    public static void main(String[] args) {
        Test7 test7 = new Test7();
        System.out.println(test7.Fibonacci(1));
        System.out.println(test7.Fibonacci(2));
        System.out.println(test7.Fibonacci(3));
        System.out.println(test7.Fibonacci(4));
        System.out.println(test7.Fibonacci(5));
        System.out.println(test7.Fibonacci(6));
        System.out.println(test7.Fibonacci(7));

    }
}
