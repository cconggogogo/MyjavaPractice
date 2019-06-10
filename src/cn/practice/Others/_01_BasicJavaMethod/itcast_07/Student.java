package cn.practice.Others._01_BasicJavaMethod.itcast_07;

public class Student {
	private String name;
	private int age;
	private boolean flag; // Ĭ�������û�����ݣ������true��˵��������

	public synchronized void set(String name, int age) {
		// ��������ݣ��͵ȴ�
		if (this.flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// ��������
		this.name = name;
		this.age = age;

		// �޸ı��
		this.flag = true;
		this.notify();
	}

	public synchronized void get() {
		// ���û�����ݣ��͵ȴ�
		if (!this.flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// ��ȡ����
		System.out.println(this.name + "---" + this.age);

		// �޸ı��
		this.flag = false;
		this.notify();
	}
}
