package cn.practice.BZhan._01_NIO;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 管道流的练习
 */
public class CopyFile {
    public static void main(String[] args) {

    }
    public static void copyFile() throws Exception{
        // 映射流
        RandomAccessFile in = new RandomAccessFile("a.txt","r");
        RandomAccessFile out = new RandomAccessFile("a.txt","w");
        // 获得通道流
        FileChannel fcIn = in.getChannel();
        FileChannel fcOut = out.getChannel();

        long size = fcIn.size();

        // 定义输入和输出的缓冲区
        MappedByteBuffer inBuf = fcIn.map(FileChannel.MapMode.READ_ONLY,0,size);
        MappedByteBuffer outBuf = fcOut.map(FileChannel.MapMode.READ_WRITE,0,size);

        for (int i = 0; i< size;i++){
            outBuf.put(inBuf.get(i));
        }

        // 关闭流
        fcIn.close();
        fcOut.close();
        in.close();
        out.close();
    }
}
