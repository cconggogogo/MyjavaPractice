package cn.practice.Interview.tengxun.mianshi;

import org.junit.Test;
import java.util.*;

/**
 * 有一个网站的日志文件，记录用户的登录信息，
 * 每个ip登录一次，就在日志文件记录一次该ip，
 * 求访问次数最多的前十个ip，要求能在单机访问，如日志记录为:
 * 12.15.35.189
 * 23.15.147.32
 * 65.32.15.485
 * ......
 */
public class CountIp {
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
        System.out.println(getTop10Ip(lists));
    }
    public List<String> getTop10Ip(List<String> lists){
        List<String> res = new ArrayList<String>();// 保存最终的结果
        List<Integer> counts = new ArrayList<Integer>(); // 最终结果对应的下标
        HashMap<String,Integer> hm = new HashMap<String,Integer>();
        for(int i = 0;i < lists.size();i++){
            if(!hm.containsKey(lists.get(i))){
                hm.put(lists.get(i),1);
            } else{
                String key = lists.get(i);
                int value= hm.get(key);
                hm.put(key,value+1);
            }// else
        }
        Set<String> set = hm.keySet();
        int count = 0;
        for (String key: set ){
            Integer value = hm.get(key);
            if (count<10){
                res.add(key);
                counts.add(value);
                count++;
            } else {
                if(value> Collections.min(counts)){
                    int index = counts.indexOf(Collections.min(counts));
                    counts.set(index,value);
                    res.set(index,key);
                }
            }
        }
        for (int i = 0;i < res.size();i++){
            System.out.println(res.get(i) + ": " + counts.get(i));
        }
        return res;
    }
}
