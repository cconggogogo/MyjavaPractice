package cn.practice.Algorithm.JianZhiOffer.before;

/**
 * 给定一个二维数组，其每一行从左到右递增排序，
 * 从上到下也是递增排序。给定一个数，判断这个数是否在该二维数组中。
 */

/**
 * 解题思路
 * 要求时间复杂度O（M+N），空间复杂度0（1）。其中M为行数，N为列数。
 * 该二维数组中的一个数，小于它的数一定在其左边，
 * 大于它的数一定在其下边。因此，从右上角开始查找，
 * 就可以根据target和当前元素的大小关系来缩小查找区间，
 * 当前元素的查找区间为左下角的所有元素。
 */
public class FindInTwoArray {
    public boolean find(int target, int[][] arrays){
        if (arrays == null || arrays.length == 0 || arrays[0].length == 0){
            return false;
        }
        // rows: 行数，cols：列数
        int rows = arrays.length, cols = arrays[0].length;
        int r = 0, c = cols - 1;

        while (r <= rows - 1 && c >= 0){
            if (target == arrays[r][c])
                return true;
            else if (target > arrays[r][c])
                r++;
            else
                c--;
        }
        return false;
    }
}
