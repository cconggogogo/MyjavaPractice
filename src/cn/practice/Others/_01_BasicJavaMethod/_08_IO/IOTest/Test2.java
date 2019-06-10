package cn.practice.Others._01_BasicJavaMethod._08_IO.IOTest;

import java.io.*;

public class Test2 {
    public static void main(String[] args) throws IOException{
        test1();
        test2();
        test3();
        test4();
    }

    private static void test4() throws IOException{
        FileInputStream fis = new FileInputStream("F:\\FileDemo\\test\\a.txt");
        FileOutputStream fos = new FileOutputStream("copyfile4");
        int len = 0;
        byte[] bys = new byte[1024];
        while ((len = fis.read(bys)) != -1) {
            fos.write(bys,0,len);
        }
        fis.close();
        fos.close();
    }

    public static void test3() throws IOException{
        FileInputStream fis = new FileInputStream("F:\\FileDemo\\test\\a.txt");
        FileOutputStream fos = new FileOutputStream("copyfile3");
        int by = 0;
        while ((by = fis.read()) != -1) {
            fos.write(by);
        }
        fis.close();
        fos.close();
    }
    public static void test2() throws  IOException{
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("F:\\FileDemo\\test\\a.txt"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("newFile2"));
        int len = 0;
        byte[] bys = new byte[1024];
        while ((len = bis.read(bys)) != -1) {
            bos.write(bys, 0, len);
        }
        bos.close();
        bis.close();
    }

    public static void test1() throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("F:\\FileDemo\\test\\a.txt"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("newFile"));
        int by = 0;
        while ((by = bis.read()) != -1) {
            bos.write(by);
        }
        bos.close();
        bis.close();
    }
}
