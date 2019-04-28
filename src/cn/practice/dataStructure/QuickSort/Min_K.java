package cn.practice.dataStructure.QuickSort;

import java.util.Arrays;



public class Min_K {
    public static void main(String[] args) {
        int[] a={8,4,5,6,9,2,2,2,3};
        quickSort(a, 0, a.length-1,1);
        quickSort(a, 0, a.length-1,2);
        quickSort(a, 0, a.length-1,3);
        quickSort(a, 0, a.length-1,4);
        quickSort(a, 0, a.length-1,5);
        quickSort(a, 0, a.length-1,6);
        quickSort(a, 0, a.length-1,7);
        quickSort(a, 0, a.length-1,8);
        quickSort(a, 0, a.length-1,9);
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
    }
    public static void quickSort(int[] a,int low ,int high,int k){
        if(low>high){
            return ;
        }
        int i=low;
        int j=high;
        int temp=a[low];
        while(i<j){
            while(i<j&&a[j]>temp){
                j--;
            }
            if(i<j){
                a[i]=a[j];
                i++;
            }
            while(i<j&&a[i]<temp){
                i++;
            }
            if(i<j){
                a[j]=a[i];
                j--;
            }

        }
        a[i]=temp;
        if(k==i+1){
            System.out.println(temp);
            return ;
        }else if(k<i+1){
            quickSort(a, low,i-1,k);
        }else{
            quickSort(a, i+1, high,k);
        }
    }


}

