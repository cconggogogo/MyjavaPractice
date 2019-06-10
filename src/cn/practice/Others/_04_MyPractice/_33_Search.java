package cn.practice.Others._04_MyPractice;

/**
 * 4 5 6 7 0 1 2
 * 本来有序得数组，在某个位置调换了顺序
 * 判断是否存在某个元素
 */
public class _33_Search {
    public static void main(String[] args) {
        System.out.println(search(new int[]{4,5,6,7,0,1,2},3));
        System.out.println(search(new int[]{4,5,6,7,0,1,2},4));
        System.out.println(search(new int[]{4,5,6,7,0,1,2},5));
        System.out.println(search(new int[]{4,5,6,7,0,1,2},2));
    }
    public static int search(int[] nums, int target){
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end){
            int mid = (start + end )/2;
            if (nums[mid] == target)
                return mid;
            // 前面一段是有序得
            else if (nums[start] <= nums[mid]){
                if (nums[start] <= target && target <= nums[mid])
                    end = mid;
                else
                    start = mid;
            } else {
                if (nums[mid] <= target && target <= nums[end]){
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        if (nums[start] == target)
            return start;
        if (nums[end] == target)
            return end;
        return -1;
    }
}
