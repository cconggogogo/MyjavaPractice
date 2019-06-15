package cn.practice.Algorithm.DataStructure._04_sort;

import java.util.Arrays;

public class Insert {
    public static void main(String[] args) {
        int[] arr = {25,45,3,1,0,59,4,12,3};
//        insertSort(arr);
        insertSort2(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort2(int[] arr) {
        // 折半插入排序
        int i,j,mid,low,high,temp;
        for (i=1;i<arr.length;i++) {
            temp = arr[i];
            low = 0;
            high = i-1;
            while (low<=high) {
                mid = (low + high) /2;
                if (arr[mid] >= temp) {
                    high = mid -1;
                } else if (arr[mid] < temp) {
                    low = mid +1;
                }
            }
            for (j = i-1;j>=high+1;j--) {
                arr[j+1] =arr[j];
            }
            arr[high+1] = temp;
        }
    }

    // 直接插入排序
    public static void insertSort(int[] arr) {
        int i,j,temp;
        for (i=0; i<arr.length; i++) {
            temp = arr[i];
            j=i-1;
            while (j>=0 && temp<arr[j]) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] =temp;
        }
     }
}
