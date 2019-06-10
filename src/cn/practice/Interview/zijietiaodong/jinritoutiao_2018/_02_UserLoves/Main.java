package cn.practice.Interview.zijietiaodong.jinritoutiao_2018._02_UserLoves;
/**
 * 第1行为n代表用户的个数 第2行为n个整数，
 * 第i个代表用户标号为i的用户对某类文章的喜好度 第3行为一个正整数q代表查询的组数,
 * 第4行到第(3+q)行，每行包含3个整数l,r,k代表一组查询，
 * 即标号为l<=i<=r的用户中对这类文章喜好值为k的用户的个数。
 * 数据范围n<=300000,q<=300000n<=300000,q<=300000，k是整型。
 *
 * 输出：
 *
 * 一共q行，每行一个整数代表喜好值为k的用户的个数。
 * 样例输入：
 *
 * 5
 * 1 2 3 3 5
 * 3
 * 1 2 1
 * 2 4 5
 * 3 5 3
 * 样例输出：
 *
 * 1
 * 0
 * 2
 */

/**
 * 分析：
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
