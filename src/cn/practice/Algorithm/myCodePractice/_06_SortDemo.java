package cn.practice.Algorithm.myCodePractice;

import org.junit.Test;

import java.util.*;

public class _06_SortDemo {
    public List<String> topKFrequent(List<String> lists, int k){
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String item : lists){
            hashMap.put(item, hashMap.getOrDefault(item,0) + 1);
        }
        List<String>[] buckets = new List[lists.size() + 1];
        for (String key : hashMap.keySet()){
            int value = hashMap.get(key);
            if (buckets[value] == null){
                buckets[value] = new ArrayList<>();
            }
                buckets[value].add(key);
        }
        List<String> topK = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && topK.size() < k; i--){
            if (buckets[i] == null)
                continue;
            if (buckets[i].size() < k - topK.size())
                topK.addAll(buckets[i]);
            else
                topK.addAll(buckets[i].subList(0,k - topK.size()));
        }
        return topK;
    }

    public String frequencyString(String s){
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for (char c: s.toCharArray()){
            hashMap.put(c,hashMap.getOrDefault(c,0) + 1);
        }
        List<Character>[] lists = new ArrayList[s.length() + 1];
        for (char key : hashMap.keySet()){
            int value = hashMap.get(key);
            if (lists[value] == null){
                lists[value] = new ArrayList<>();
            }
                lists[value].add(key);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = lists.length - 1; i >= 0; i--){
            if (lists[i] == null)
                continue;
            for (int j = 0; j < lists[i].size(); j++){
                for (int k = 0; k < i; k++){
                    stringBuilder.append(lists[i].get(j));
                }
            }
        }
        return stringBuilder.toString();
    }

    public int findKthLargest(int[] nums, int k){
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public int findKthLargest2(int[] nums, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int item : nums){
            pq.add(item);
            if (pq.size() > k)
                pq.poll();
        }
        return pq.peek();
    }

    public int findKthLargest3(int[] nums, int k){
        k = nums.length - k;
        int l = 0, r = nums.length - 1;
        while (l < r){
            int j = quickSort(nums,l,r);
            if (j == k)
                break;
            else if (j < k){
                l = j + 1;
            } else {
                r = j - 1;
            }
        }
        return nums[k];
    }

    @Test
    public void test(){
        int[] nums = {1,2,3,4,5,6};
        System.out.println(findKthLargest3(nums,2));
    }

    public int quickSort(int[] nums, int start, int end){
        int i = start, j = end;
        if (start > end) return -1;
        int temp = nums[start];
        while (i < j){
            while (i < j && nums[j] >= temp)
                j--;
            if (i < j){
                nums[i++] = nums[j];
            }
            while (i < j && nums[i] < temp)
                i++;
            if (i < j){
                nums[j--] = nums[i];
            }
        }
        return i;
    }
}
