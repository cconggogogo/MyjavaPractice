package cn.practice.Others._01_BasicJavaMethod.itcast_07;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * ���л������Ѷ�������һ���ķ�ʽ�����ı��ļ������������д��䡣���� -- ������(ObjectOutputStream)
 * �����л���:���ı��ļ��е����������ݻ��������е����������ݻ�ԭ�ɶ��������� -- ����(ObjectInputStream)
 */
public class ObjectStreamDemo {
	public static void main(String[] args) throws IOException,
			ClassNotFoundException {
		// ��������Ҫ�Զ���������л��������������Զ���һ����
		// ���л�������ʵ���ǰѶ���д���ı��ļ�
//		 write();

		read();
	}

	private static void read() throws IOException, ClassNotFoundException {
		// ���������л�����
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
				"oos.txt"));

		// ��ԭ����
		Object obj = ois.readObject();

		// �ͷ���Դ
		ois.close();

		// �������
		System.out.println(obj);
	}

	private static void write() throws IOException {
		// �������л�������
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
				"oos.txt"));

		// ��������
		Person p = new Person("wahaha", 30);

		// public final void writeObject(Object obj)
		oos.writeObject(p);
		// �ͷ���Դ
		oos.close();
	}
}
