package cn.practice.Algorithm.JianZhiOffer.before;

/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的，也
 * 不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 */

import org.junit.Test;

/**
 * 解题思路
 * 要求时间复杂度O（N），空间复杂度O（1）。因此不能使用排序的方法，
 * 也不能使用额外的标记数组。对于这种数组元素在[0，n-1]范围内的问题，
 * 可以将值为i的元素调整到第i个位置上进行求解。
 * 以（2，3，1，0，2，5）为例，遍历到位置4时，该位置上的数为2，
 * 但是第2个位置上已经有一个2的值了，因此可以知道2重复：
 */
public class DuplicateNumber {
    @Test
    public void test(){
        int[] duplication = new int[10];
        int[] nums = {1,2,3,4,4};
        System.out.println(duplicate(nums,nums.length,duplication));
        System.out.println(duplication[0]);
    }
    public boolean duplicate(int[] nums,int length, int[] duplication){
        if (nums == null || length <=0)
            return false;
        for (int i = 0; i < length;i++){
            // 当前位置为冲突位置(不是正确的位置)
            while (nums[i]!=i){
                // 其实nums[i]应该放的位置为nums[i]
                if (nums[i] == nums[nums[i]]){ // 冲突了
                    duplication[0] = nums[i];
                    return true;
                } else {
                    swap(nums,i,nums[i]);// 每次将nums[i]放到正确的位置
                }
            }
        }
        return false;
    }

    private void swap(int[] nums, int i, int num) {
        int temp = nums[i];
        nums[i] = nums[num];
        nums[num] = temp;
    }
}
