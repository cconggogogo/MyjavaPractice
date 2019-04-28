package cn.practice.Leetcode._01_TwoSum;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given nums=[2,7,11,15],target = 9
 * return [0,1];
 * time:O（n）
 * space:O(n)
 */

/**
 * 思路：
 * 通过map来实现，只需要遍历一次，遍历到Nums[i]的时候
 * 查看之前map中有无和nums[i]加起来等于target的元素
 */
public class _01_TwoSum {
    public static void main(String[] args) {
        int[] res = twoSum(new int[]{2,7,11,15},13);
        System.out.println(Arrays.toString(res));
    }

    public static int[] twoSum(int[] nums,int target){
        if (nums == null || nums.length<2)
            return new int[]{-1,-1};
        int[] res = new int[]{-1,-1};
        // 键是具体的值，值是下标
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i<nums.length;i++){
            if (map.containsKey(target-nums[i])){
                res[0] = map.get(target-nums[i]);
                res[1] = i;
                break;
            }
            map.put(nums[i],i);
        }
        return res;
    }

}
