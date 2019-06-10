package cn.practice.Algorithm.JianZhiOffer.before;
/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。
 * 找出那个只出现了一次的元素。
 */

/**
 * 解法：异或
 *
 * 异或运算的特点：两个相同的数字异或，结果为0。
 *
 * 因为数组中除了一个元素只出现一次之外，其它的元素都出现两次，
 * 如果把所有的数都异或，相同的数字异或为0，
 * 最后只剩下出现一次的数字，它和0异或，结果就是它本身。
 *
 * 一个数对另外一个数异或两次等于这个数本身
 * a = a ^ b ^ b;
 */
class Solution {
    public int singleNumber(int[] nums) {
        int num = 0;
        for(int i = 0; i < nums.length; i++){
            num = num ^ nums[i];
        }
        return num;
    }
}


public class FindOnlyOneTimeItem {
    public static void main(String[] args) {
        int[] data = new int[]{17,12,5,-6,12,4,17,-5,2,-3,2,4,5,16,-3,-4,15,15,-4,-5,-6};
        Solution sol = new Solution();
        System.out.println(sol.singleNumber(data));
    }
}
