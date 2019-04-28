package cn.practice.BZhan._02_JDK8.lambda.practice.basicMethod._04_stream;

import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _01_PersonTest {
    @Test
    public void test(){
        List<Person> javaProgrammes = new ArrayList<>();
        javaProgrammes.add(new Person("Jarrod", "Pace", "PHP programmer", "male", 34, 1550));
        javaProgrammes.add(new Person("Clarette", "Cicely", "PHP programmer", "female", 23, 1200));
        javaProgrammes.add(new Person("Victor", "Channing", "PHP programmer", "male", 32, 1600));
        javaProgrammes.add(new Person("Jarrod", "Pace", "PHP programmer", "male", 34, 1550));
        javaProgrammes.add(new Person("Jarrod", "Pace", "PHP programmer", "male", 34, 1550));
        javaProgrammes.add(new Person("Jarrod", "Pace", "PHP programmer", "male", 34, 1550));
        javaProgrammes.add(new Person("Jarrod", "Pace", "PHP programmer", "male", 34, 1550));
        javaProgrammes.add(new Person("Jarrod", "Pace", "PHP programmer", "male", 34, 1550));
        javaProgrammes.add(new Person("Jarrod", "Pace", "PHP programmer", "male", 34, 1550));
        javaProgrammes.add(new Person("Jarrod", "Pace", "PHP programmer", "male", 34, 1550));

        List<Person> phpProgrammers = new ArrayList<>();
        phpProgrammers.add(new Person("Jarrod", "Pace", "PHP programmer", "male", 34, 1550));
        phpProgrammers.add(new Person("Tori", "Sheryl", "PHP programmer", "female", 21, 1000));
        phpProgrammers.add(new Person("Jarrod", "Pace", "PHP programmer", "male", 34, 1550));

        // 遍历
        javaProgrammes.forEach(p -> System.out.println(p.getFirstName() + "-" + p.getLastName()));

        // 同样使用forEach方法,增加程序员的工资5%:
        System.out.println("给程序员加薪 5% :");
        Consumer<Person> giveRaise = e -> e.setSalary(e.getSalary()/100*5 + e.getSalary());
        javaProgrammes.forEach(giveRaise);
        javaProgrammes.forEach(p -> System.out.println(p.getSalary()));

        // filter：让我们显示月薪超过1400美元的PHP程序员
        System.out.println("filter的用法：");
        javaProgrammes.stream().filter(p -> p.getSalary() < 1400).forEach(p -> System.out.println(p.getSalary()));;

        // 自定义过滤器
        Predicate<Person> ageFilter = p -> p.getAge()> 25;
        Predicate<Person> salaryFilter = p -> p.getSalary() > 1400;
        Predicate<Person> genderFilter = p -> "female".equals(p.getGender());

        System.out.println("下面是年龄大于 24岁且月薪在$1,400以上的女PHP程序员:");
        phpProgrammers.stream().filter(ageFilter)
                .filter(salaryFilter)
                .filter(genderFilter).forEach(
                        p -> System.out.println(p.getFirstName())
        );

        // limit方法的使用
        System.out.println("最前面的3个 Java programmers:");
        javaProgrammes.stream().limit(3)
                .forEach(p -> System.out.println(p.getFirstName()));
        System.out.println("最前面的3个女性Java programmers:");
        javaProgrammes.stream().limit(3).filter(genderFilter)
                .forEach(p -> System.out.println(p.getFirstName()));

        /**
         * 排序：
         * collect的作用:
         * 使用 collect
         * 方法来将我们的结果集放到一个字符串,
         * 一个 Set 或一个TreeSet中:
         */
        System.out.println("根据 name 排序,并显示前5个 Java programmers:");
        List<Person> sortedJavaProgrammers = javaProgrammes.stream()
                .sorted((p1, p2) -> p1.getLastName().compareTo(p2.getFirstName()))
                .limit(5)
                .collect(Collectors.toList());

        // min和max方法
        System.out.println("工资最低的 Java programmer:");
        Person pers = javaProgrammes.stream()
                .min((p1, p2) -> p1.getSalary() - p2.getSalary())
                .get();
    }

    /**
     * 通过collect，将结果集放到对应的容器中
     */

    @Test
    public void test2(){
        List<Person> javaProgrammes = new ArrayList<>();
        javaProgrammes.add(new Person("Jarrod", "Pace", "PHP programmer", "male", 34, 1550));
        javaProgrammes.add(new Person("Clarette", "Cicely", "PHP programmer", "female", 23, 1200));
        javaProgrammes.add(new Person("Victor", "Channing", "PHP programmer", "male", 32, 1600));
        List<Person> phpProgrammers = new ArrayList<>();
        phpProgrammers.add(new Person("Jarrod", "Pace", "PHP programmer", "male", 34, 1550));
        phpProgrammers.add(new Person("Tori", "Sheryl", "PHP programmer", "female", 21, 1000));
        phpProgrammers.add(new Person("Jarrod", "Pace", "PHP programmer", "male", 34, 1550));

        /**
         * collect的使用
         */
        System.out.println("将 PHP programmers 的 first name 拼接成字符串:");
        String collect = phpProgrammers.stream()
                .map(Person::getFirstName)
                .collect(Collectors.joining(";"));
        System.out.println(collect);// Jarrod;Tori;Jarrod


        System.out.println("将 Java programmers 的 first name 存放到 TreeSet:");
        TreeSet<String> treeSet = javaProgrammes.stream()
                .map(Person::getFirstName)
                .collect(Collectors.toCollection(TreeSet::new));

        System.out.println("将 Java programmers 的 first name 存放到 Set:");
        Set<String> set = phpProgrammers.stream()
                .map(Person::getFirstName)
                .collect(Collectors.toSet());

        /**
         * 并行执行
         */

        System.out.println("计算付给 Java programmers 的所有money:");
        int sum = javaProgrammes.parallelStream()
                .mapToInt(p -> p.getSalary()).sum();

        /**
         * 使用summaryStatistics方法
         * 获得stream 中元素的各种汇总数据
         * 比如getMax, getMin, getSum或getAverage:
         */
        List<Integer> lists = Arrays.asList(1,2,3,4,5,6,7,8,9);
        IntSummaryStatistics stats = lists.stream().mapToInt(x -> x)
                .summaryStatistics();
        System.out.println("max: " + stats.getMax());
        System.out.println("getMin: " + stats.getMin());
        System.out.println("getAverage: " + stats.getAverage());
        System.out.println("getCount: " + stats.getCount());
        System.out.println("getSum: " + stats.getSum());
    }
}
