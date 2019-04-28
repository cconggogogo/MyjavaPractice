package cn.practice.MyPractice.zijietiaodong;

import java.util.Scanner;

public class Main2 {
    public static int dp(int i, int j, int[] location){
        if (i == j)
            return 0;
        if (i + 1 == j)
            return location[j] - location[i] - 1;
        else
            return dp(i+1, j-1, location) + location[j] - location[i] - (j-i-1) -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int m = sc.nextInt();
        int[][] numbers = new int[s.length()][26];
        for (int i = 0; i < s.length(); i++){
            numbers[i][s.charAt(i) - 'a'] = 1;
        }
        for (int i = 0; i < s.length(); i++){
            for (int j = 0; j < 26; j++){
                System.out.print(numbers[i][j] + "  ");
            }
            System.out.println();
        }
        int[] nums = new int[26];
        for (int i = 0; i < 26; i++){
            // 存放当前字母存放的位置
            int[] location = new int[s.length()];
            int k = 0;
            for (int j = 0; j < s.length(); j++){
                if (numbers[j][i] == 1){
                    location[k++] = i;
                }
            }
            if (k == 1)
                nums[i] = 1;
            else {
                int temp = -1;
                for (int p = 0; p < k; p++){
                    for (int q = p + 1; q < k; q++){
                        int res = dp(p, q, location);
                        if (res <= m){
                            if (q - p + 1 > temp){
                                temp = q - p + 1;
                            }
                        }
                    }
                }
                nums[i] = temp;
            }
        }
        int sum = nums[0];
        for (int i = 1; i < 26; i++){
            if (nums[i] > sum){
                sum = nums[i];
            }
        }
        System.out.println(sum);
    }
}
