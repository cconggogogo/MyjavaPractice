package cn.practice.MyPractice.zijietiaodong;

import java.util.*;

public class _02_UserLove {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 用户得个数
        int[] loves = new int[n];
        for (int i = 0; i < n; i++){
            loves[i] = sc.nextInt();
        }
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++){
            int key = loves[i];
            int value = i+1;
            if (!map.containsKey(key)){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(value);
                map.put(key,list);
            } else {
                ArrayList<Integer> list = map.get(key);
                list.add(value);
            }
        }
        int m = sc.nextInt();
        ArrayList<Integer> queue = new ArrayList<>();
        for (int i = 0; i< m ; i++){
            int l = sc.nextInt();
            int r = sc.nextInt();
            int value = sc.nextInt();
            int count = 0;
            if (map.containsKey(value)){
                ArrayList<Integer> list = map.get(value);
                for (Integer k:list){
                    if (l<=k&&k<=r){
                        count++;
                    }
                }
            }
            queue.add(count);
        }
        for (Integer i:queue){
            System.out.println(i);
        }
    }
}
