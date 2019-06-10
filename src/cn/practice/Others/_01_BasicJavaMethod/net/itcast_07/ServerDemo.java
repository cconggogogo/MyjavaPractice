package cn.practice.Others._01_BasicJavaMethod.net.itcast_07;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
	public static void main(String[] args) throws IOException {
		// ����������Socket����
		ServerSocket ss = new ServerSocket(9989);

		// �����ͻ��˵�����
		Socket s = ss.accept(); // ����(���ǵȵ��ͻ��������˲ſ���ִ��)

		// ��ȡ������
		InputStream is = s.getInputStream();
		byte[] bys = new byte[1024];
		int len = is.read(bys); // ����
		String server = new String(bys, 0, len);
		System.out.println("server:" + server);

		// ��ȡ�����
		OutputStream os = s.getOutputStream();
		os.write("get".getBytes());

		// �ͷ���Դ
		s.close();
		// ss.close();
	}
}
