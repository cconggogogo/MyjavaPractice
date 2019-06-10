package cn.practice.Others._01_BasicJavaMethod._08_IO.IOTest.OtherStream;

import java.io.*;
import java.util.Properties;
import java.util.Set;

public class ProperitiesDemo {
    public static void main(String[] args) throws IOException {
//        test1();
        test2();
    }

    public static void test2() throws IOException{
        Properties pr = new Properties();
        Reader r = new FileReader("count.txt");
        pr.load(r);
        String value = pr.getProperty("count");
        int number = Integer.parseInt(value);

        if (number > 3) {
            System.out.println("您已经试玩结束");
            System.exit(0);
        } else {
            GuessNumber.start();
            number++;
            Writer w = new FileWriter("count.txt");
            pr.setProperty("count", String.valueOf(number));
            pr.store(w, null);
            w.close();
        }
        r.close();
        pr.clear();

    }

    public static void test1() throws IOException{
        Properties pr = new Properties();
        Reader reader = new FileReader("name.txt");
        pr.load(reader);
        Set<String> set = pr.stringPropertyNames();
        for (String str: set) {
            if (str.equalsIgnoreCase("002")) {
                pr.setProperty(str, "002newName");
                break;
            }
        }
        reader.close();
        Writer writer = new FileWriter("name.txt");
        pr.store(writer, null);
        pr.clear();
    }
}
