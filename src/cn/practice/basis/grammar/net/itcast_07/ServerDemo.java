package cn.practice.basis.grammar.net.itcast_07;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
	public static void main(String[] args) throws IOException {
		// 创建服务器Socket对象
		ServerSocket ss = new ServerSocket(9989);

		// 监听客户端的连接
		Socket s = ss.accept(); // 阻塞(就是等到客户端连我了才可以执行)

		// 获取输入流
		InputStream is = s.getInputStream();
		byte[] bys = new byte[1024];
		int len = is.read(bys); // 阻塞
		String server = new String(bys, 0, len);
		System.out.println("server:" + server);

		// 获取输出流
		OutputStream os = s.getOutputStream();
		os.write("get".getBytes());

		// 释放资源
		s.close();
		// ss.close();
	}
}
