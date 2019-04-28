package cn.practice.MyPractice.zijietiaodong;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class _03_BraceletsTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 佛珠的个数
        int m = sc.nextInt(); // 每一种颜色的佛珠在任意连续的m个串珠里至多出现一次
        int c = sc.nextInt(); // 佛珠的颜色总数
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++){
            int num = sc.nextInt();
            for (int j = 0; j < num; j++){
                int key = sc.nextInt();
                if (!map.containsKey(key)){
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(i);
                    map.put(key,list);
                } else {
                    ArrayList<Integer> list = map.get(key);
                    list.add(i);
                }
            }
        }
        int count = 0;
        for (int i = 1; i <= c; i++){
            boolean flag = false;
            ArrayList<Integer> list = map.get(i);
            if (list.size() == 1){
                continue;
            } else {
                for (int j = 0; j < list.size() - 1; j++){
                    if (list.get(j+1) - list.get(j) < m){
                        count++;
                        flag = true;
                        break;
                    }
                }
                if (!flag){
                    if (n - list.get(list.size() - 1) + list.get(0) < m){
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
