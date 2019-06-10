package cn.practice.Others._01_BasicJavaMethod.net.demo2.itcast_05;

import java.io.IOException;
import java.net.DatagramSocket;

/*
 * ͨ�����̸߳Ľ��ղŵ�������������ҾͿ���ʵ����һ�����ڷ��ͺͽ���������
 */
public class ChatRoom {
	public static void main(String[] args) throws IOException {
		DatagramSocket dsSend = new DatagramSocket();
		DatagramSocket dsReceive = new DatagramSocket(12445);

		SendThread st = new SendThread(dsSend);
		ReceiveThread rt = new ReceiveThread(dsReceive);

		Thread t1 = new Thread(st);
		Thread t2 = new Thread(rt);

		t1.start();
		t2.start();
	}
}
