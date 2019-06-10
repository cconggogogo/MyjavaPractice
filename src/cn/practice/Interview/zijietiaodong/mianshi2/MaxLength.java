package cn.practice.Interview.zijietiaodong.mianshi2;

import java.util.ArrayList;

/**
 * 求最长匹配的长度
 * 例如：
 *  2 2 1 1 1 2 2 2 2
 *      1 1 1 2 2 2
 *  返回：6
 */
public class MaxLength {
    public static void main(String[] args) {
        int[] arr = {2,2,1,1,1,2,2,2,2};
        int[] arr2 = {1,2,1,2,1,2};
        int[] arr3 = {1,2,2,1,1,2};
        int[] arr4 = {1,2,2,2,1,2,1,1,1};
        System.out.println(maxLength(arr));
        System.out.println(maxLength(arr2));
        System.out.println(maxLength(arr3));
        System.out.println(maxLength(arr4));
    }
    public static int maxLength(int[] arr){
        ArrayList<Integer> list = new ArrayList<>();
        int max = 0;
        int count = 1;
        for (int i = 0;i < arr.length - 1;i++){
            if (arr[i] == arr[i+1]){
                count++;
            } else {
                list.add(count);
                count = 1;
            }
        }
        list.add(count); // 注意最后一次的情况，需要单独处理
        System.out.println("list: " + list);
        for (int i = 0;i< list.size() - 1;i++){
            if (Math.min(list.get(i),list.get(i+1)) > max){
                max = Math.min(list.get(i),list.get(i+1));
            }
        }
        return 2 * max;
    }
}
