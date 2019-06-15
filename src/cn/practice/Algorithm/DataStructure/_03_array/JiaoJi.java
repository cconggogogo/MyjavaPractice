package cn.practice.Algorithm.DataStructure._03_array;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 交集
 *
 * time:排序+核心代码；
 *  O(nlogn) + O(n) = O(nlogn)
 *  space: O(n)
 */
public class JiaoJi {
    public static void main(String[] args) {
        int[] arrA = {3,5,1,0,8,6,4};
        int[] arrB = {7,5,5,0,9,1,4};
        Arrays.sort(arrA);
        Arrays.sort(arrB);
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i=0,j=0;i<arrA.length&&j<arrB.length;){
            if (arrA[i]<arrB[j]){
                i++;
            } else if (arrA[i]>arrB[j]){
                j++;
            } else {
                hashSet.add(arrA[i]);
                i++;
                j++;
            }
        }
        System.out.println(Arrays.toString(hashSet.toArray()));
    }
}
