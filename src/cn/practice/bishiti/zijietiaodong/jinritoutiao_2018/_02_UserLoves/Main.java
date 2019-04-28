package cn.practice.bishiti.zijietiaodong.jinritoutiao_2018._02_UserLoves;
/**
 * 用户喜好：
 * 关键在于，把用户得喜好得值存储到hashmap中作为键，值是这个喜好对应得用户
 * 下面的话就直接根据喜好得值找到对应用户得列表
 * 依次判断这些用户是否在给定得段就可以了
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        method();
    }
    public static void method(){
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt(); // 用户的个数
        int[] fav=new int[n]; // 这n个用户的喜好数据
        for(int i=0;i<n;i++){
            fav[i]=scan.nextInt();
        }
        // 存放的是key-list(key在那几个位置出现过)
        Map<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            int key=fav[i]; // 当前的值
            int value=i+1; // 第几个
            if(!map.containsKey(key)){
                List<Integer> list=new LinkedList<>();
                list.add(value);
                map.put(key,list);
            }else{
                List<Integer> list=map.get(key);
                list.add(value);
            }
        }
        System.out.println(map);
        int m=scan.nextInt();
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<m;i++){
            int lo=scan.nextInt();
            int hi=scan.nextInt();
            int des=scan.nextInt();
            List<Integer> list=map.get(des);
            int count=0;
            if(list!=null){
                for(Integer integer:list){
                    if(integer>=lo&&integer<=hi){
                        count++;
                    }
                }
            }

            queue.add(count);

        }
        for(Integer integer:queue){
            System.out.println(integer);
        }
    }

    // 暴力解法(略)
    public static void method1(){

    }
}
