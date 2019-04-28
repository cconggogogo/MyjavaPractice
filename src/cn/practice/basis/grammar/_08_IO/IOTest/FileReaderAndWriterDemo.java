package cn.practice.basis.grammar._08_IO.IOTest;

import java.io.*;

public class FileReaderAndWriterDemo {
    public static void main(String[] args) throws IOException{
//        test1();
//        test2();
//        test3();
        test4();
    }

    public static void test4() throws IOException{
        // 第一种
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("newFileosw.txt"));
        InputStreamReader osr = new InputStreamReader(new FileInputStream("newFile.txt"));
        int len = 0;
        char[] chs = new char[1024];
        while ((len = osr.read(chs)) != -1) {
            osw.write(chs,0,len);
            osw.flush();
        }
        osr.close();
        osw.close();

        // 第二种
        FileWriter fw = new FileWriter("newFilefw.txt");
        FileReader fr = new FileReader("newFile.txt");
        while ((len = fr.read(chs)) != -1) {
            fw.write(chs,0,len);
        }
        fr.close();
        fw.close();

        // 第三种
        BufferedWriter bw = new BufferedWriter(new FileWriter("newFilebw.txt"));
        BufferedReader br = new BufferedReader(new FileReader("newFile.txt"));
        while ((len = br.read(chs)) !=-1) {
            bw.write(chs,0,len);
        }
        br.close();
        bw.close();

        // 第四种
        BufferedWriter bw2 = new BufferedWriter(new FileWriter("newFilebww.txt"));
        BufferedReader br2 = new BufferedReader(new FileReader("newFile.txt"));
        String line = null;
        while ((line = br2.readLine()) != null) {
            bw2.write(line);
            bw2.newLine();
        }
        bw2.close();
        br2.close();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static void test3() throws IOException {
        File file = new File("newFile.txt");
        file.createNewFile();
        FileOutputStream fos = new FileOutputStream(file);
        for (int x = 0; x<10; x++) {
            fos.write("胡阳阳 hello world".getBytes());
            fos.write("\r\n".getBytes());
        }
    }

    public static void test2() throws IOException{
        FileWriter fw = new FileWriter("copyNewFile.txt");
        FileReader fr = new FileReader("newFile");
//        int ch = 0;
//        while ((ch = fr.read()) != -1) {
//            fw.write(ch);
//        }

        char[] chs = new char[1024];
        int len = 0;
        while ((len = fr.read(chs))!= -1) {
            fw.write(chs,0,len);
        }
        fr.close();
        fw.close();
    }
    public static void test1() throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("newFile"), "UTF-8");
        int ch = -1;
        while ((ch = isr.read()) !=-1) {
            System.out.println((char)ch);
        }

    }
}
