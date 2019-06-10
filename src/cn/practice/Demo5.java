package cn.practice;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeMap;

public class Demo5 {
    public static void main(String[] args) {
        print();
    }

    public static void print(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 格式
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        int[] res = new int[n];
        for (int i = 0; i<n;i++){
            int num = sc.nextInt();
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int j = 0;j<num;j++){
                arrayList.add(sc.nextInt());
            }
            map.put(i,arrayList);
        }
        for (int i = 0;i<n;i++){
            ArrayList<Integer> list = map.get(i);
            if (i<n-1){
                ArrayList<Integer> list1 = map.get(i+1);
                for (int a=0;a<list.size();a++){
                    list1.add(list.get(a));
                }
            }
            Collections.sort(list);
            if (list.size()<=3){
                res[i]=Collections.max(list);
            }else {
                 int j;
                 if (list.size()%3==1){
                     for (j=list.size()-1;j>3;j=j-3){
                         res[i]+=list.get(j);
                     }
                         res[i]+=list.get(j);
                         res[i]+=list.get(j-2);
                 } else {
                     for (j=list.size()-1;j>=0;j=j-3){
                         res[i]+=list.get(j);
                     }
                     if (j-3>=0){
                         res[i]+=list.get(j-3);
                     }
                 }
             }

        }
        for (int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }
    }
}
