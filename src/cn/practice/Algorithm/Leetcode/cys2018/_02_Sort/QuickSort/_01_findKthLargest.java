package cn.practice.Algorithm.Leetcode.cys2018._02_Sort.QuickSort;

/**
 * 快速选择
 *
 * 用于求解 Kth Element 问题，也就是第 K 个元素的问题。
 *
 * 可以使用快速排序的 partition() 进行实现。需要先打乱数组，
 * 否则最坏情况下时间复杂度为 O(N2)。
 *
 *
 * 堆
 *
 * 用于求解 TopK Elements 问题，也就是 K 个最小元素的问题。
 * 可以维护一个大小为 K 的最小堆，最小堆中的元素就是最小元素。
 * 最小堆需要使用大顶堆来实现，大顶堆表示堆顶元素是堆中最大元素。
 * 这是因为我们要得到 k 个最小的元素，因此当遍历到一个新的元素时，
 * 需要知道这个新元素是否比堆中最大的元素更小，更小的话就把堆中最大元素去除，
 * 并将新元素添加到堆中。所以我们需要很容易得到最大元素并移除最大元素，
 * 大顶堆就能很好满足这个要求。
 *
 * 堆也可以用于求解 Kth Element 问题，得到了大小为 k 的最小堆之后，因为使用了大顶堆来实现，因此堆顶元素就是第 k 大的元素。
 *
 * 快速选择也可以求解 TopK Elements 问题，因为找到 Kth Element 之后，再遍历一次数组，所有小于等于 Kth Element 的元素都是 TopK Elements。
 *
 * 可以看到，快速选择和堆排序都可以求解 Kth Element 和 TopK Elements 问题。
 */

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1. Kth Element
 *
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 *
 * 题目描述：找到倒数第 k 个的元素。
 */
public class _01_findKthLargest {
    @Test
    public void test(){
        int[] nums = {3,2,1,5,6,4};
        System.out.println(new _01_findKthLargest().findKthLargest(nums,6));
        System.out.println(new _01_findKthLargest().findKthLargest2(nums,6));
        System.out.println(new _01_findKthLargest().findKthLargest3(nums,6));
    }
    /**
     * 排序 ：时间复杂度 O(NlogN)，空间复杂度 O(1)
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k){
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * 堆 ：时间复杂度 O(NlogK)，空间复杂度 O(K)。
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest2(int[] nums, int k){
        // 默认是小根堆
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int val: nums){
            pq.add(val);
            if (pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }

    public int findKthLargest3(int[] nums, int k){
        k = nums.length - k;
        int l = 0, h = nums.length - 1;
        while (l < h){
            int j = partition2(nums,l,h);
            if (j == k){
                break;
            } else if (j < k){
                l = j + 1;
            } else {
                h = j - 1;
            }
        }
        return nums[k];
    }

    public int partition(int[] a, int l, int h){
        int i = l, j = h + 1;
        while (i < j){
            while (a[++i] < a[l] && i < h);
            while (a[--j] > a[l] && j > l);
            if (i < j){
                swap(a,i,j);
            }
        }
        return j;
    }

    /**
     * 快排找到第一个元素的有序的位置的下标
     * @param a
     * @param l
     * @param h
     * @return
     */
    public int partition2(int[] a, int l, int h){
        int i = l, j = h;
        if (l < h){
            int temp = a[l];
            while (i < j){
                while (i < j && a[j] >= temp)
                    j--;
                if (i < j){
                    a[i++] = a[j];
                }
                while (i < j && a[i] < temp)
                    i++;
                if (i < j){
                    a[j--] = a[i];
                }
            }
        }
        return i;
    }

    public void swap(int[] a, int i ,int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
