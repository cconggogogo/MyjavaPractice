package cn.practice.Others._01_BasicJavaMethod.BZhan._01_NIO;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

/**
 * NIO的paths接口和Files工具类
 */
public class _02_GetPath {
    public static void main(String[] args) throws IOException {
        // 获得文件路径的方式
        File file = new File("e:\\test");
        Path p1 = Paths.get("e:\\","test");

        Path p2 = file.toPath();

        Path p3 = FileSystems.getDefault().getPath("e:\\","test");

        // Files工具类
        // 写入文件
        Path p4 = Paths.get("e:\\");
        String info = "dfsfdsaf";
        try {
            Files.write(p4,info.getBytes("gb2312"),StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 读取文件
        byte[] bys = Files.readAllBytes(p4);

        // 移动
        Files.move(p4,Paths.get("e:\\demo"));
        // 复制
        Files.copy(p4,Paths.get("e:\\demo"));
    }
}
