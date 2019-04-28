package cn.practice.MyPractice.zijietiaodong;

import java.util.Arrays;
import java.util.Scanner;

public class _01_maxMapping {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = 0;
        String str;
        int[] numbers = new int[10];
        for (int i = 0; i < n; i++){
            str = sc.nextLine();
            while (str == null || str.equals("")){
                str = sc.nextLine();
            }
            for (int j = str.length()-1;j>=0;j--){
                numbers[str.charAt(j) - 'A'] += Math.pow(10,str.length()-j-1);
            }
        }
        Arrays.sort(numbers);
        for (int i = 0; i < 10;i++){
            max+=i*numbers[i];
        }
        System.out.println("max: " + max);
    }
}
