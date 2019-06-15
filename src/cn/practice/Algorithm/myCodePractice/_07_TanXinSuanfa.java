package cn.practice.Algorithm.myCodePractice;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _07_TanXinSuanfa {
    public int findContentChildren(int[] children, int[] cookies){
        int i = 0, j = 0;
        Arrays.sort(children);
        Arrays.sort(cookies);
        while (i < children.length && j < cookies.length){
            if (children[i] <= cookies[j])
                i++;
            j++;
        }
        return i;
    }

    public int eraseOverlapIntervels(int[][] nums){
        if (nums.length < 2)
            return 0;
        Arrays.sort(nums,(a,b) -> (a[0] - b[0]));
        int max = nums[0][1];
        int toRemove = 0;
        for (int i = 1; i < nums.length; i++){
            if (nums[i][0] > max){
                toRemove++;
                max = Math.min(max,nums[i][1]);
            } else {
                max = nums[i][1];
            }
        }
        return toRemove;
    }

    public int[][] reconstructQueue(int[][] people){
        if (people == null || people.length == 0 || people[0].length == 0)
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
        Arrays.sort(people,(a,b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));
        List<int[]> list = new ArrayList<>();
        for (int[] item : people){
            list.add(item[1],item);
        }
        return list.toArray(new int[list.size()][]);
    }

    public int maxProfit(int[] nums){
        if (nums.length == 0)
            return 0;
        int minPrice = nums[0];
        int max = 0;
        for (int i = 1; i < nums.length; i++){
            if (minPrice > nums[i])
                minPrice = nums[i];
            max = Math.max(max, nums[i] - minPrice);
        }
        return max;
    }

    public int duiciMaxProfit(int[] nums){
        if (nums.length == 0)
            return 0;
        int max = 0;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] > nums[i - 1])
                max += (nums[i] - nums[i - 1]);
        }
        return max;
    }

    public boolean canPlaceFlowers(int[] nums, int n){
        int can = 0;
        for (int i = 0; i < nums.length && can < n; i++){
            if (nums[i] == 1)
                continue;
            int pre = i == 0 ? 0 : nums[i - 1];
            int next = i == nums.length - 1 ? 0 : nums[i + 1];
            if (pre == 0 && next == 0){
                can++;
                nums[i] = 1;
            }
        }
        return can >= n;
    }

    public boolean isSub(String s, String t){
        int i = 0, j = 0;
        while ( i < s.length() && j < t.length()){
            if (s.charAt(i) == t.charAt(j)){
                j++;
            }
            i++;
        }
        return j == t.length();
    }

    public boolean checkPossibility(int[] nums){
        int count = 0;
        for (int i = 1; i < nums.length && count < 2; i++){
            if (nums[i] >= nums[i - 1])
                continue;
            count++;
            if (nums[i - 2] > nums[i] && i >= 2)
                nums[i] = nums[i - 1];
            else
                nums[i - 1] = nums[i];
        }
        return count <= 1;
    }

    public int maxSubArray(int[] nums){
        if (nums == null || nums.length == 0)
            return 0;
        int preSum = nums[0];
        int maxSum = preSum;
        for (int i = 1; i < nums.length; i++){
            preSum = preSum > 0 ? preSum + nums[i] : nums[i];
            maxSum = Math.max(maxSum, preSum);
        }
        return maxSum;
    }

    public int charToIndex(char c){
        return c - 'a';
    }

    public List<Integer> partitionLabels(String s){
        int[] indexs = new int[26];
        for (int i = 0; i < s.length(); i++){
            indexs[charToIndex(s.charAt(i))] = i;
        }
        List<Integer> res = new ArrayList<>();
        int firstIndex = 0;
        while (firstIndex < s.length()){
            int lastIndex = firstIndex;
            for (int i = firstIndex; i < s.length() && i <= lastIndex; i++){
                int index = indexs[charToIndex(s.charAt(i))];
                if (index > lastIndex)
                    lastIndex = index;
            }
            res.add(lastIndex - firstIndex + 1);
            firstIndex = lastIndex + 1;
        }
        return res;
    }


    @Test
    public void test(){
        System.out.println(isSub("ABC","AC"));
    }
}
