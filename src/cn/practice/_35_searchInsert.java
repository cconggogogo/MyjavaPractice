package cn.practice;

/**
 * 寻找元素得下标
 */
public class _35_searchInsert {
    public static void main(String[] args) {

    }
    public static int searchInsert(int[] arr, int target){
        int start = 0, end = arr.length - 1;
        while (start + 1 < end){
            int mid = (start + end) / 2;
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] > target)
                end = mid;
            else
                start = mid;
        }
        if (target < arr[start])
            return start;
        else if (target <= arr[end])
            return end;
        else
            return end + 1;
    }
}
