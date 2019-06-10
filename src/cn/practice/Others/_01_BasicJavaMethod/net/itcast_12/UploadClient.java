package cn.practice.Others._01_BasicJavaMethod.net.itcast_12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/*
 * ��������������˼·���뷴����Ϣ�����ȴû��Ӧ��Ϊʲô��?
 * ��ȡ�ı��ļ��ǿ�����null��Ϊ������Ϣ�ģ������أ�ͨ�����ǲ�������������Ϣ�ġ�
 * ���ԣ������������Ͳ�֪��������ˡ����㻹����������㷴�������ԣ����໥�ȴ��ˡ�
 * 
 * ��ν����?
 * A:�ڶ�дһ�����ݣ����߷���������ȡ����������˵���Ҿͽ�������Ҳ�����ɡ�
 * 		���������Խ�����⣬���ǲ��á�
 * B:Socket�����ṩ��һ�ֽ������
 * 		public void shutdownOutput()
 */

public class UploadClient {
	public static void main(String[] args) throws IOException {
		// �����ͻ���Socket����
		Socket s = new Socket("PC-201809222213", 12345);

		// ��װ�ı��ļ�
		BufferedReader br = new BufferedReader(new FileReader(
				"a.txt"));
		// ��װͨ������
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				s.getOutputStream()));

		String line = null;
		while ((line = br.readLine()) != null) { // ����
			bw.write(line);
			bw.newLine();
			bw.flush();
		}
		
		//�Զ���һ���������
//		bw.write("over");
//		bw.newLine();
//		bw.flush();
		
		//Socket�ṩ��һ����ֹ������֪ͨ�����������ˣ���û�����ݹ�����
		s.shutdownOutput();

		// ���շ���
		BufferedReader brClient = new BufferedReader(new InputStreamReader(
				s.getInputStream()));
		String client = brClient.readLine(); // ����
		System.out.println(client);

		// �ͷ���Դ
		br.close();
		s.close();
	}
}
