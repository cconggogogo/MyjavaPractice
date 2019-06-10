package cn.practice.Others._01_BasicJavaMethod.net.itcast_08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/*
 * �ͻ��˼���¼�룬���������������̨
 */
public class ClientDemo {
	public static void main(String[] args) throws IOException {
		// �����ͻ���Socket����
		Socket s = new Socket("PC-201809222213", 22222);

		// ����¼������
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// ��ͨ���ڵ�������װһ��
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				s.getOutputStream()));

		String line = null;
		while ((line = br.readLine()) != null) {
			// ����¼������Ҫ�Զ���������
			if ("886".equals(line)) {
				break;
			}
			bw.write(line);
			bw.newLine();
			bw.flush();
		}

		// �ͷ���Դ
		// bw.close();
		// br.close();
		s.close();
	}
}
