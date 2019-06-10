package cn.practice.Others._01_BasicJavaMethod._08_IO.IOTest;

import java.io.*;


public class Test1 {
    public static void main(String[] args) throws IOException {
//     test1();
//        test2();
        test3();
    }

    public static void test3() throws IOException{
        System.out.println("读数据的第一种方法");
        FileInputStream fis = new FileInputStream("F:\\FileDemo\\test\\a.txt");
        int by = 0;
        if ((by = fis.read()) != -1) {
            System.out.println((char)by);
        }
        System.out.println();
        System.out.println("第二种方法");
        byte[] bys = new byte[1024];
        int len = 0;
        while ((len = fis.read(bys))!=-1) {
            System.out.println(new String(bys,0,len));
        }
        System.out.println();
        System.out.println("复制文件");
        FileOutputStream fos = new FileOutputStream("newaaa.jpg");
        FileInputStream fis1 = new FileInputStream("aaa.jpg");
        int by1 = 0;
        while ((by1 = fis.read()) != -1) {
            fos.write(by1);
        }
        fis1.close();
        fis.close();
        fos.close();

    }

    public static void test2() {
        System.out.println("规范化异常代码");
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("F:\\FileDemo\\test\\a.txt", true);
            fos.write("hello world".getBytes());
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }finally {
            if (fos !=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
    public static void test1() throws IOException {
        File file = new File("F:\\FileDemo\\test\\a.txt");
//        FileOutputStream fileOutputStream = new FileOutputStream("F:\\FileDemo\\test");
//        FileOutputStream fileOutputStream1 = new FileOutputStream(file);
        FileOutputStream fileOutputStream2 = new FileOutputStream(file,true);

        byte[] bys = {99,100,102,103,105};

        for (int x = 0; x< 10; x++) {
            fileOutputStream2.write(bys);
            fileOutputStream2.write("\r\n".getBytes());
        }
        fileOutputStream2.close();
    }
}
