package cn.practice.Algorithm.Leetcode.cys2018._02_Sort.Bucket;

import org.junit.Test;

import java.util.*;

/**
 * 1. 出现频率最多的 k 个元素
 *
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 *
 * 设置若干个桶，每个桶存储出现频率相同的数。桶的下标表示数出现的频率，
 * 即第 i 个桶中存储的数出现的频率为 i。
 *
 * 把数都放到桶之后，从后向前遍历桶，
 * 最先得到的 k 个数就是出现频率最多的的 k 个数。
 */
public class _01_topKFrequent {
    @Test
    public void test(){
        List<String> lists = new ArrayList<>();
        lists.add("1.2.3.4");
        lists.add("1.2.3.4");
        lists.add("1.2.3.4");
        lists.add("1.2.3.4");
        lists.add("1.2.3.4");
        lists.add("1.2.3.4");//6
        lists.add("125.25.36.85");
        lists.add("125.25.36.85");
        lists.add("125.25.36.85");
        lists.add("125.25.36.85");
        lists.add("125.25.36.85");
        lists.add("125.25.36.85");
        lists.add("125.25.36.85");
        lists.add("125.25.36.85");
        lists.add("125.25.36.85");
        lists.add("125.25.36.85");//10
        lists.add("58.454.54.54");
        lists.add("58.454.54.54");
        lists.add("58.454.54.54");
        lists.add("58.454.54.54");
        lists.add("58.454.54.54");//5
        lists.add("5.8.9.7");
        lists.add("5.8.9.7");
        lists.add("5.8.9.7");
        lists.add("5.8.9.7");
        lists.add("5.8.9.7");
        lists.add("5.8.9.7");
        lists.add("5.8.9.7");
        lists.add("5.8.9.7");//8
        lists.add("15.80.49.70");
        lists.add("15.80.49.70");
        lists.add("15.80.49.70");
        lists.add("15.80.49.70");//4
        lists.add("105.80.49.70");
        lists.add("105.80.49.70");//2
        lists.add("105.80.490.70");
        lists.add("105.80.490.70");
        lists.add("105.80.490.70");
        lists.add("105.80.490.70");
        lists.add("105.80.490.70");//5
        lists.add("105.80.490.0");
        lists.add("105.80.490.0");//2
        lists.add("5.80.70.0");
        lists.add("5.80.70.0");//2
        lists.add("5.80.125.0");
        lists.add("5.80.125.0");//2
        lists.add("0.0.0.0");//1
        lists.add("0.0.1.1");//1
        List<String> res = topKFrequent(lists,2);
        for (String item: res){
            System.out.println(item);
        }
    }


    public List<String> topKFrequent(List<String> lists, int k){
        // 存放每一个元素出现的频数
        Map<String,Integer> frequencyForNum = new HashMap<>();
        for (String list: lists){
            frequencyForNum.put(list,frequencyForNum.getOrDefault(list,0) + 1);
        }
        List<String>[] buckets = new ArrayList[lists.size() + 1];
        /**
         * 创建桶，桶k存放频次为k的元素
         */
        for (String key: frequencyForNum.keySet()){
            int frequency = frequencyForNum.get(key);
            if (buckets[frequency] == null){
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }
        List<String> topK = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0&& topK.size() < k;i--){
            if (buckets[i] == null)
                continue;
            if (buckets[i].size() <= (k - topK.size()))
                topK.addAll(buckets[i]);
            else {
                topK.addAll(buckets[i].subList(0,k - topK.size())); // 0-（k - topK.size()-1）
            }
        }
        return topK;
    }
}
