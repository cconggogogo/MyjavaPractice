package cn.practice.Others._01_BasicJavaMethod._08_IO.IOTest.OtherStream;

import java.io.*;

public class SystemInDemo {
    public static void main(String[] args) throws IOException {
//        SystemInDemo();
        SystemOutDemo();
    }

    private static void SystemOutDemo() throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write("hello");
        bw.write("\r\n");
        bw.write("world");
        bw.write("\r\n");
        bw.write("java iloveYou");
        bw.flush();
        bw.close();
    }

    public static void SystemInDemo() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        System.out.println("请输入一个字符串");
        line = br.readLine();
        System.out.println(line);
    }
}
