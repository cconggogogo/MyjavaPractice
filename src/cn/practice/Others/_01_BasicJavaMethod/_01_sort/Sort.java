package cn.practice.Others._01_BasicJavaMethod._01_sort;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8};
        System.out.println("二分查找_4在数组中的下标为：" + Binary_search(4, array));
        System.out.println();

        int[] array2 = {5,3,2,6,3,7,6};
        // 测试java自带的Array方法
        Arrays.sort(array2);
        System.out.println("测试sout排序方法");
        printArray(array2);
        System.out.println();

        System.out.println("测试toString方法");
        System.out.println(Arrays.toString(array2));
        System.out.println();

        System.out.println("测试二分查找方法");
        System.out.println("查找3在数组中的下标：" + Arrays.binarySearch(array2,3));

    }

    public static int Binary_search(int x, int[] array){
        int max = array.length - 1;
        int min = 0;
        int mid = (max + min);

        while (x != array[mid]) {
            if (array[mid] > x) {
                max = mid -1;
            } else if (array[mid] < x) {
                min = mid + 1;
            }

            if (min > max) {
                return -1 ;
            }

            mid = (min + max) / 2;
        }

        return array[mid];
    }

    public static void printArray(int[] array) {
        System.out.print("数组的内容为：" + " ");
        for (int index = 0; index<array.length; index++){
            if (index != array.length-1){
                System.out.print(array[index] + ",");
            } else {
                System.out.println(array[index]);
            }
        }
    }
}
