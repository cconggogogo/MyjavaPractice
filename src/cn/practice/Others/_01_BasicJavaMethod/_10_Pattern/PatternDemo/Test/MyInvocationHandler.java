package cn.practice.Others._01_BasicJavaMethod._10_Pattern.PatternDemo.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
	private Object target; // Ŀ�����

	public MyInvocationHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("Ȩ��У��");
		Object result = method.invoke(target, args);
		System.out.println("��־��¼");
		return result; // ���ص��Ǵ������
	}
}
