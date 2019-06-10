package cn.practice.Others._01_BasicJavaMethod.net.itcast_15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class UserThread implements Runnable {
	private Socket s;

	public UserThread(Socket s) {
		this.s = s;
	}

	@Override
	public void run() {
		try {
			// ��װͨ���ڵ���
			BufferedReader br = new BufferedReader(new InputStreamReader(
					s.getInputStream()));
			// ��װ�ı��ļ�
			// BufferedWriter bw = new BufferedWriter(new
			// FileWriter("Copy.java"));

			// Ϊ�˷�ֹ���Ƴ�ͻ
			String newName = System.currentTimeMillis() + ".147852369java";
			BufferedWriter bw = new BufferedWriter(new FileWriter(newName));

			String line = null;
			while ((line = br.readLine()) != null) { // ����
				bw.write(line);
				bw.newLine();
				bw.flush();
			}

			// ��������
			BufferedWriter bwServer = new BufferedWriter(
					new OutputStreamWriter(s.getOutputStream()));
			bwServer.write("success");
			bwServer.newLine();
			bwServer.flush();

			// �ͷ���Դ
			bw.close();
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
