package cn.practice.Leetcode;

/**
 * 和leetcode（26和80题相近）
 * time:O(n)
 * space:O(1)
 *
 * 给一个数组 和一个val
 * 删掉值为val的元素，返回剩下的数组
 * 例如：
 * input:[3,2,2,3]和val=3
 * 返回：[2,2],length = 2
 *
 * time:O(n)
 * space:O(1)
 */
public class _26_RemoveElement {
    public static void main(String[] args) {
        System.out.println(reverseElement(new int[]{3,2,3,3},2));
    }
    public static int reverseElement(int[] nums, int val){
        if (nums == null || nums.length == 0) return 0;
        int res = 0;
        for (int i = 0;i < nums.length; i++){
            if (nums[i] != val){
                nums[res++] = nums[i];
            }
        }
        return res;
    }
}
