package cn.practice.JavaMethod;

import java.util.Arrays;

public class CopyArr {
    public static void main(String[] args) {
//        copyArr1ToArr2_02();
//        copyArr1ToArr2_03();
        copyArr1ToArr2_04();
    }

    // for循环
    public static void copyArr1ToArr2_01(){
    }

    // System.arraycopy,深克隆
    // System.arraycopy(arr1,0,arr2,0,arr1.length);
    // 从arr1的0号位置复制arr1.length放到arr2的0号位置
    public static void copyArr1ToArr2_02(){
        int[] arr1 = {1,2,3,4,5,6,7};
        int[] arr2 = new int[arr1.length];
        System.arraycopy(arr1,0,arr2,0,arr1.length);
        arr1 = null;
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
    // Arrays.copyof,深克隆
    // 第一个参数是原来的数组名，第二个参数是数组的长度
    public static void copyArr1ToArr2_03(){
        int[] arr1 = {1,2,3,4,5,6,7};
        int[] arr2 = new int[arr1.length];
        arr2 = Arrays.copyOf(arr1,arr1.length);
        arr1 = null;
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

    // object的clone方法，深克隆
    public static void copyArr1ToArr2_04(){
        int[] arr1 = {1,2,3,4,5,6,7};
        int[] arr2 = new int[arr1.length];
        arr2 = arr1.clone();
        arr1 = null;
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
}
