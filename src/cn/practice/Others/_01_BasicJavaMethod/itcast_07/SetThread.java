package cn.practice.Others._01_BasicJavaMethod.itcast_07;

public class SetThread implements Runnable {

	private Student s;
	private int x = 0;

	public SetThread(Student s) {
		this.s = s;
	}

	@Override
	public void run() {
		while (true) {
			if (x % 2 == 0) {
				s.set("����ϼ", 27);
			} else {
				s.set("����", 30);
			}
			x++;
		}
	}
}
