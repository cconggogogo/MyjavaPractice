package cn.practice.dataStructure.sort;

import java.util.Arrays;

public class Select {
    public static void main(String[] args) {
        int[] arr = {25,45,3,1,0,59,4,12,3};
//        SelectSort(arr);
        mergerSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void SelectSort(int[] arr) {
        int i,j,k,temp;
        for (i = 0;i<arr.length-1;i++) {
            k = i;
            for (j = i+1;j<arr.length;j++) {
                if (arr[k]>arr[j])
                    k = j;
                temp = arr[k];
                arr[k] = arr[j];
                arr[j] = temp;
            }
        }
    }

    public static void mergerSort(int[] arr,int low, int high) {
        if (low<high) {
            int mid = (low + high)/2;
            mergerSort(arr,low,mid);
            mergerSort(arr,mid+1,high);
            merger(arr,low,mid,high);
        }
    }

    private static void merger(int[] arr, int low, int mid, int high) {
        int[] newArr = new int[arr.length];
        int i,j,k;
        for (k=low;k<=high;k++) {
            newArr[k] = arr[k];
        }
        for (i=low,j=mid+1,k=i;i<=mid&&j<=high;k++) {
            if (newArr[i]<newArr[j])
                arr[k] = newArr[i++];
            else
                arr[k] = newArr[j++];
        }
        while (i<=mid)
            arr[k++]=newArr[i++];
        while (j<=high)
            arr[k++]=newArr[j++];
    }
}
