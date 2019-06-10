package cn.practice.Others._01_BasicJavaMethod.net.itcast_07;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientDemo {
	public static void main(String[] args) throws IOException {
		// �����ͻ���Socket����
		Socket s = new Socket("PC-201809222213", 9989);

		// ��ȡ�����
		OutputStream os = s.getOutputStream();
		os.write("go play".getBytes());

		// ��ȡ������
		InputStream is = s.getInputStream();
		byte[] bys = new byte[1024];
		int len = is.read(bys);// ����
		String client = new String(bys, 0, len);
		System.out.println("client:" + client);

		// �ͷ���Դ
		s.close();
	}
}
