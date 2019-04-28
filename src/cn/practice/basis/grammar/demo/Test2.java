package cn.practice.basis.grammar.demo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Test2 {
    public static void main(String[] args) throws Exception{

        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("a.txt",true));
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("a.txt"));
        bos.write("hello world".getBytes());
        bos.write("\r\n".getBytes());
        bos.write("java".getBytes());

        byte[] bys = new byte[1024];
        int len = 0;
        while ((len = bis.read(bys))!= -1){
            System.out.println(new String(bys,0,len));
        }
        bis.close();
        bos.close();
    }
}
