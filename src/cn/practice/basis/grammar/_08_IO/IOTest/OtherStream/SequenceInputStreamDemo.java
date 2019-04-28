package cn.practice.basis.grammar._08_IO.IOTest.OtherStream;

import java.io.*;

public class SequenceInputStreamDemo {
    public static void main(String[] args) throws IOException {
        test();
    }
    public static void test() throws IOException{
        System.out.println("sequence一次性写多个文件的内容到新的文件中");
        InputStream is1 = new FileInputStream("newFile.txt");
        InputStream is2 = new FileInputStream("name.txt");
        SequenceInputStream sis = new SequenceInputStream(is1, is2);
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("bos.txt"));

        byte[] chs = new byte[1024];
        int len =0;
        while ((len = sis.read(chs)) != -1){
            bos.write(chs, 0, len);
        }
        sis.close();
        bos.close();
    }
}
