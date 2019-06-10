package cn.practice.Others._01_BasicJavaMethod.net.itcast_12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class UploadServer {
	public static void main(String[] args) throws IOException {
		// �����������˵�Socket����
		ServerSocket ss = new ServerSocket(12345);

		// �����ͻ�������
		Socket s = ss.accept();// ����

		// ��װͨ���ڵ���
		BufferedReader br = new BufferedReader(new InputStreamReader(
				s.getInputStream()));
		// ��װ�ı��ļ�
		BufferedWriter bw = new BufferedWriter(new FileWriter("Copy.java"));

		String line = null;
		while ((line = br.readLine()) != null) { // ����
		// if("over".equals(line)){
		// break;
		// }
			bw.write(line);
			bw.newLine();
			bw.flush();
		}

		// ��������
		BufferedWriter bwServer = new BufferedWriter(new OutputStreamWriter(
				s.getOutputStream()));
		bwServer.write("success");
		bwServer.newLine();
		bwServer.flush();

		// �ͷ���Դ
		bw.close();
		s.close();
	}
}
