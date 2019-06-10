package cn.practice.Others._01_BasicJavaMethod.net.itcast_06;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * TCPЭ��������ݣ�
 * A:�������ն˵�Socket����
 * B:�����ͻ������ӡ�����һ����Ӧ��Socket���󣡣�����������������������
 * C:��ȡ����������ȡ������ʾ�ڿ���̨
 * D:�ͷ���Դ
 */
public class ServerDemo {
	public static void main(String[] args) throws IOException {
		// �������ն˵�Socket����
		// ServerSocket(int port)
		ServerSocket ss = new ServerSocket(8888);

		// �����ͻ������ӡ�����һ����Ӧ��Socket����
		// public Socket accept()
		Socket s = ss.accept(); // ���������ܵ����׽��ֵ����ӡ��˷��������Ӵ���֮ǰһֱ������

		// ��ȡ����������ȡ������ʾ�ڿ���̨
		InputStream is = s.getInputStream();

		byte[] bys = new byte[1024];
		int len = is.read(bys); // ����ʽ����
		String str = new String(bys, 0, len);

		String ip = s.getInetAddress().getHostAddress();

		System.out.println(ip + "---" + str);

		// �ͷ���Դ
		s.close();
		// ss.close(); //�����Ӧ�ùر�
	}
}
