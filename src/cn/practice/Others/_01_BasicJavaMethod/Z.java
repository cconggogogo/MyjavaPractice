package cn.practice.Others._01_BasicJavaMethod;

/*
	������д�����
		A:��Ա����������
			int x = 10; //��Ա�����ǻ�������
			Student s = new Student(); //��Ա��������������
		B:һ����ĳ�ʼ������
			��Ա�����ĳ�ʼ��
				Ĭ�ϳ�ʼ��
				��ʾ��ʼ��
				���췽����ʼ��
		C:�Ӹ���ĳ�ʼ��(�ֲ��ʼ��)
			�Ƚ��и����ʼ����Ȼ����������ʼ����
			
	�����
		YXYZ
		
	���⣺
		��Ȼ�����й��췽��Ĭ����һ��super()
		��ʼ����ʱ�򣬲��ǰ����Ǹ�˳����еġ�
		���ǰ��շֲ��ʼ�����еġ�
		��������ʾҪ�ȳ�ʼ���������ݣ��ٳ�ʼ���������ݡ�
*/
class X {
	Y b = new Y("xy");
	X(String s) {
		System.out.println(s);
	}
}

class Y {
	Y(String s) {
		System.out.println(s);
	}
}

public class Z extends X {
	Y y = new Y("zy");
	Z(String s) {
		super(s);
		System.out.println(s);
	}
	public static void main(String[] args) {
		new Z("z");
	}
}