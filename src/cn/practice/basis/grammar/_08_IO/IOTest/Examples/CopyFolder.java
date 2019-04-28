package cn.practice.basis.grammar._08_IO.IOTest.Examples;

import java.io.*;

public class CopyFolder {
    public static void main(String[] args) throws IOException {
//        test1();
        test2();
    }

    public static void test2() throws IOException{
        File srcFolder = new File("F:\\FileDemo\\test");
        File distFolder = new File("F:\\FileDemo\\test3");
        if (!distFolder.exists()) {
            distFolder.mkdir();
        }
        copyFolder(srcFolder,distFolder);

    }

    private static void copyFolder(File srcFolder, File distFolder) throws IOException{
        if (srcFolder.isDirectory()){
            File newFile = new File(distFolder,srcFolder.getName());
            newFile.mkdir();
            File[] files = srcFolder.listFiles();
            for (File file: files){
                copyFolder(file,newFile);
            }
        } else {
            File newFile = new File(distFolder,srcFolder.getName());
            copyFile(srcFolder,newFile);
        }
    }

    public static void test1() throws IOException{
        File srcFolder = new File("F:\\FileDemo\\test");
        File distFolder = new File("F:\\FileDemo\\test2");

        if (!distFolder.exists()) {
            distFolder.mkdir();
        }

        File[] files = srcFolder.listFiles();
        for (File file: files) {
            File newFile = new File(distFolder,file.getName());
            copyFile(file,newFile);
        }
    }

    private static void copyFile(File file, File newFile) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        BufferedWriter bw = new BufferedWriter(new FileWriter(newFile));
        String line = null;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        bw.close();
        br.close();
    }
}
