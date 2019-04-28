package cn.practice.MovieLearn._03_guavax;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.collect.*;

import java.text.SimpleDateFormat;
import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        // 过滤功能
//        List<String> list = Lists.newArrayList("hello","world","java");
//        Collection<String> collention = Collections2.filter(list, e->e.startsWith("j"));
//        collention.forEach(System.out::println);

        // 转换功能
//        Set<Long> timeSet = Sets.newHashSet(201900401L,20190501L);
//        Collection<String> collection = Collections2.transform(timeSet,(e)->new SimpleDateFormat("yyyy-MM-dd").format(e));
//        collection.forEach(System.out::println);

//        // 组合式的函数编程
//        List<String> list = Lists.newArrayList("hello","world","java");
//        Function<String,String> f1 = new Function<String, String>() {
//            @Override
//            public String apply(String s) {
//                return s.length()>4? toString().substring(0,4):s;
//            }
//        };
//        Function<String,String> f2 = new Function<String, String>() {
//            @Override
//            public String apply(String s) {
//                return s.toUpperCase();
//            }
//        };
//        Function<String,String> f = Functions.compose(f1,f2);
//        Collection<String> collection = Collections2.transform(list,f);
//        collection.forEach(System.out::println);

//        // 集合操作：交集，并集，差集
//        Set<Integer> s1 = Sets.newHashSet(1,3,4);
//        Set<Integer> s2 = Sets.newHashSet(2,4,5);
//        Sets.SetView<Integer> v = Sets.intersection(s1,s2);
//        v.forEach(System.out::println);
//
//        // 差集
//        Sets.SetView<Integer> v2 = Sets.difference(s1,s2);
//        v2.forEach(System.out::println);
//
//        // 并集
//        Sets.SetView<Integer> v3 = Sets.union(s1,s2);
//        v2.forEach(System.out::println);

//        // 无序可重复Multiset
//        String s = "good good java" +
//                "java good good java world";
//        String[] ss = s.split(" ");
//        HashMultiset<String> set = HashMultiset.create();
//        for (String str: ss){
//            set.add(str);
//        }
//        Set<String> strings = set.elementSet();
//        for (String str: strings){
//            System.out.println(str + ":" + set.count(str));
//        }

//        // Multimap：key可重复
//        Map<String,String> map = new HashMap<>();
//        map.put("001","java");
//        map.put("002","javase");
//        map.put("003","java");
//        map.put("004","javase");
//        map.put("005","javase");
//        Multimap<String,String> mmap = ArrayListMultimap.create();
//        Iterator<Map.Entry<String,String>> entryIterator = map.entrySet().Iterator();
//        while (entryIterator.hasNext()){
//            Map.Entry<String,String> entry = entryIterator.next();
//            mmap.put(entry.getValue(),entry.getKey());
//        }
//        Set<String> keySet = mmap.keySet();
//        for (String key: keySet){
//            Collection<String> values = mmap.get(key);
//            System.out.println(key + ":" + values);
//        }

//        //BiMap：双向Map（bidirectionalMap）键与值不能重复
//        BiMap<String,String> map = HashBiMap.create();
//        map.put("001","zs");
//        map.put("002","zs");
//        map.put("003","zs");
//        String name = map.inverse().get("zs");
//        System.out.println(name);

        // 双键的Map
        Table<String,String,Integer> table = HashBasedTable.create();
        table.put("zs","java",120);
        table.put("lisi","java",4);
        table.put("ww","web",32432);
        table.put("zl","php",43);
        Set<Table.Cell<String,String,Integer>> set = table.cellSet();
        for (Table.Cell<String,String,Integer> c: set){
            System.out.println(c.getColumnKey() + "-" + c.getRowKey() + "-" + c.getValue());
        }
    }
}
