package cn.practice.Algorithm.Leetcode.cys2018._03_GreedyAlgorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 3. 根据身高和序号重组队列
 *
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 *
 * 题目描述：一个学生用两个分量 (h, k) 描述，h 表示身高，k 表示排在前面的有 k 个学生的身高比他高或者和他一样高。
 *
 * 为了使插入操作不影响后续的操作，身高较高的学生应该先做插入操作，否则身高较小的学生原先正确插入的第 k 个位置可能会变成第 k+1 个位置。
 *
 * 身高 h 降序、个数 k 值升序，然后将某个学生插入队列的第 k 个位置中。
 */
public class _04_reconstructQueue {
    @Test
    public void test(){
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        int[][] res = reconstructQueue(people);
        for (int[] item : res){
            System.out.println(Arrays.toString(item));
        }
    }
    public int[][] reconstructQueue(int[][] pelple){
        if (pelple == null || pelple.length == 0 || pelple[0].length == 0)
            return new int[0][0];
        /**
         * 排序之后的序列：
         * [7, 0]
         * [7, 1]
         * [6, 1]
         * [5, 0]
         * [5, 2]
         * [4, 4]
         *
         */
        Arrays.sort(pelple,(a,b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));
        List<int[]> queue = new ArrayList<>();
        // 插入时，如果覆盖了之前的元素，自动会后移
        for (int[] p: pelple){
            queue.add(p[1], p);
        }
        return queue.toArray(new int[queue.size()][]);
    }
}
