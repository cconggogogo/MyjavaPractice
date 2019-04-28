package cn.practice.dataStructure.sort;

import java.util.Arrays;

public class GuiBing {
    public static void main(String[] args) {
        int[] arr = {5,1,2,4,9,7,0};
        mergerSort(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
    public static void merge(int[] arr, int low, int mid, int high){
        int[] tempArr = arr.clone();
        int i, j, k;
        for (i = low,j = mid + 1, k = i; i <= mid && j <=high; k++){
            if (tempArr[i] < tempArr[j])
                arr[k] = tempArr[i++];
            else {
                arr[k] = tempArr[j++];
            }
        }
        while (i <= mid)
            arr[k++] = tempArr[i++];
        while (j <= high)
            arr[k++] = tempArr[j++];
    }

    public static void mergerSort(int[] arr,int low, int high){
        if (low < high){
            int mid = (low + high) / 2;
            mergerSort(arr, low, mid);
            mergerSort(arr, mid + 1, high);
            merge(arr,low,mid,high);
        }
    }
}
