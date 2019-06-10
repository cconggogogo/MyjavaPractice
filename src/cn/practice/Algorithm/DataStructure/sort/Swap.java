package cn.practice.Algorithm.DataStructure.sort;

public class Swap {
    public static void main(String[] args) {
        int[] arr = {25,45,3,1,0,59,4,12,3};
//        BubbleSort(arr);
//        QuickSort(arr,0,arr.length-1);
//        TwoBubbleSort(arr);
//        move(arr);
//        System.out.println(Arrays.toString(arr));

//        int[] arr2 = {2,2,2,2,1,1,1,1,0,0,0,0,0};
//        flag(arr2);
//        System.out.println(Arrays.toString(arr2));

        System.out.println("第k小的元素:" + min_k(arr,0,arr.length-1,5));
    }

    public static void QuickSort(int[] arr, int low, int high) {
        int temp;
        int i = low, j = high;
        if (low<high){
            temp = arr[low];
            while (i < j) {
                while (i<j && arr[j]>=temp) {
                    j--;
                }
                if (i<j){
                    arr[i] = arr[j];
                    i++;
                }
                while (i<j && arr[i]<temp) {
                    i++;
                }
                if (i<j){
                    arr[j] = arr[i];
                    j--;
                }
            }// while
            arr[i] = temp;
            QuickSort(arr,low,i-1);
            QuickSort(arr,i+1,high);
        }
    }

    public static void BubbleSort(int[] arr) {
        int i,j;
        for (i=0;i<arr.length-1;i++) {
            for (j=0;j<arr.length-i-1;j++) {
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void TwoBubbleSort(int[] arr) {
        int right=arr.length-1,left=0;
        boolean flag = true;
        int i,j;
        while (flag){
            flag=false;
            for (i=left;i<right;i++){
                if (arr[i]>arr[i+1]){
                    int temp = arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=temp;
                    flag=true;
                }
            }
            --right;
            for (j=right;j>left;j--){
                if (arr[j]<arr[j-1]){
                    int temp = arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                    flag=true;
                }
            }
            ++left;
        }
    }

    // 偶数移动到奇数前面
    public static void move(int[] arr) {
        int i = 0,j=arr.length-1;
        while (i<j) {
            while (i<j&&arr[j]%2==1)
                j--;
            while (i<j&&arr[i]%2==0)
                i++;
            if (i<j){
                int temp = arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
                j--;
            }
        }
    }

    // 红白蓝
    public static void flag(int[] arr) {
        int i=0,j=0,k=arr.length-1;
        int temp;
        while (j<=k){
            switch (arr[j]){
                case 0:
                    temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                    i++;
                    j++;
                    break;
                case 1:
                    j++;
                    break;
                case 2:
                    temp=arr[j];
                    arr[j]=arr[k];
                    arr[k]=temp;
                    k--;
                    break;
            }
        }
    }

    // 找到数组中第k小的元素
    public static int min_k(int[] arr, int low,int high,int k){
        int i=low,j=high,temp=arr[low];
        if (low < high){
            while (i<j){
                while (i<j&&arr[j]>=temp)
                    j--;
                if (i<j){
                    arr[i]=arr[j];
                    i++;
                }
                while (i<j&&arr[i]<temp)
                    i++;
                if (i<j){
                    arr[j]=arr[i];
                    j--;
                }
            }
        }
        arr[i]=temp;
        if (k-1==i)
            return arr[i];
        else if (i>k-1)
            return min_k(arr,low,i-1,k);
        else
            return min_k(arr,i+1,high,k-i-1);
    }
}
