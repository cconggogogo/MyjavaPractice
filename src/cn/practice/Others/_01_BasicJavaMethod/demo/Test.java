package cn.practice.Others._01_BasicJavaMethod.demo;

import java.io.File;
import java.io.FilenameFilter;

public class Test {
    public static void main(String[] args) {
        File file = new File("e:\\");
        String[] list = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return new File(dir,name).isFile() && name.endsWith(".jpg");
            }
        });
        for (String s: list){
            System.out.println(s);
        }

    }
}
