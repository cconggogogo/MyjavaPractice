package cn.practice.basis.grammar._08_IO.IOTest.OtherStream;

import java.io.*;

public class PrintWriterDemo {
    public static void main(String[] args) throws IOException{
        test1();
    }

    public static void test1() throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("newFile.txt"));
        // 是否自动刷新
        PrintWriter pw = new PrintWriter(new FileWriter("name.txt"), true);
        String line = null;
        while ((line = br.readLine())!= null) {
            pw.println(line);
        }
        pw.close();
        br.close();
    }
}
