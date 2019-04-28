package cn.practice.Leetcode.Array;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class Test6 {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,8,9,1,2,3};
        long time1 = System.currentTimeMillis();
        System.out.println(minNumberInRotateArray(arr));
        long time2 = System.currentTimeMillis();
        System.out.println("时间为：" + (time2-time1) + "毫秒");
    }
    public static int minNumberInRotateArray(int [] array){
        for (int x = 0;x<array.length-1;x++) {
            if (array[x]>array[x+1]){
                return array[x+1];
            }
        }
        return 1;
    }
}
