package cn.practice.Others._01_BasicJavaMethod.net.itcast_06;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/*
 * TCPЭ�鷢�����ݣ�
 * A:�������Ͷ˵�Socket����
 * 		��һ������ɹ�����˵�������Ѿ������ɹ��ˡ�
 * B:��ȡ�������д����
 * C:�ͷ���Դ
 * 
 * ���ӱ��ܾ���TCPЭ��һ��Ҫ�ȿ���������
 * java.net.ConnectException: Connection refused: connect
 */
public class ClientDemo {
	public static void main(String[] args) throws IOException {
		// �������Ͷ˵�Socket����
		// Socket(InetAddress address, int port)
		// Socket(String host, int port)
		// Socket s = new Socket(InetAddress.getByName("192.168.12.92"), 8888);
		Socket s = new Socket("PC-201809222213", 8888);

		// ��ȡ�������д����
		// public OutputStream getOutputStream()
		OutputStream os = s.getOutputStream();
		os.write("hello,tcp,������".getBytes());

		// �ͷ���Դ
		s.close();
	}
}
