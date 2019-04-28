package cn.practice.dataStructure.array;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 差集
 *  * time:排序+核心代码；
 *  *  O(nlogn) + O(n) = O(nlogn)
 *  *  space: O(n)
 */
public class ChaJi {
    public static void main(String[] args) {
        int[] arrA = {3,5,1,0,8,6,4};
        int[] arrB = {7,5,5,0,9,1,4};
        Arrays.sort(arrA);
        Arrays.sort(arrB);
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i=0,j=0;i<arrA.length&&j<arrB.length;){
            if (arrA[i]<arrB[j]){
                hashSet.add(arrA[i]);
                i++;
            } else if (arrA[i]>arrB[j]){
                j++;
            } else {
                i++;
                j++;
            }
        }
        System.out.println(Arrays.toString(hashSet.toArray()));
    }
}
