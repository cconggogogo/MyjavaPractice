package cn.practice.Algorithm.DataStructure._03_array;

import java.util.PriorityQueue;

/**
 * 要求：求中位数
 * 优先队列的做法：
 * 就是左边的优先队列存储小于右边队列的数，并且：
 * 左边是大根堆，右边是小根堆
 */
public class MidNumber {
    // 大根堆，每次拿出来的是最大的，放到右边队列中
    private PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);
    // 小根堆，每次拿出来的是最小的，放到左边队列中
    private PriorityQueue<Integer> right = new PriorityQueue<>();
    private int N = 0;

    public void Insert(Integer val){
        if (N % 2 == 0){
            left.add(val);
            right.add(left.poll());
        } else {
            right.add(val);
            left.add(right.poll());
        }
        N++;
    }

    public Double getMedian(){
        if (N % 2 == 0){
            return (left.peek() + right.peek()) / 2.0;
        } else {
            return (double)right.peek();
        }
    }

    public static void main(String[] args) {
        MidNumber midNumber = new MidNumber();
        int[] arrays = {4,5,6,7,8,9,1,2,3,10};
//        for (int i = 0; i < arrays.length; i++){
//            midNumber.Insert(arrays[i]);
//        }
//        System.out.println(Arrays.toString(midNumber.left.toArray()));
//        System.out.println(Arrays.toString(midNumber.right.toArray()));
//        System.out.println(midNumber.getMedian());

        System.out.println("midNumber: " + getMediumNumber(arrays));
    }

    public static int getMediumNumber(int[] arr){
        PriorityQueue<Integer> left = new PriorityQueue<>((o1,o2) -> o2 - o1);
        PriorityQueue<Integer> right = new PriorityQueue<>();
        int N = 0;
        for (int item: arr){
            if (N % 2 == 0){
                left.add(item);
                right.add(left.poll());
            } else {
                right.add(item);
                left.add(right.poll());
            }
            N++;
        }
        if (N % 2 == 0)
            return (left.peek() + right.peek()) / 2;
        return right.peek();
    }
}
