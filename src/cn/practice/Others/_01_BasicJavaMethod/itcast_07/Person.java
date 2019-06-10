package cn.practice.Others._01_BasicJavaMethod.itcast_07;

import java.io.Serializable;

/*
 * NotSerializableException:δ���л��쳣
 * 
 * ��ͨ��ʵ�� java.io.Serializable �ӿ������������л����ܡ�δʵ�ִ˽ӿڵ��ཫ�޷�ʹ���κ�״̬���л������л���
 * �ýӿھ�Ȼû���κη���������������û�з����Ľӿڱ���Ϊ��ǽӿڡ�
 * 
 * java.io.InvalidClassException: 
 * cn.itcast_07.Person; local class incompatible: 
 * stream classdesc serialVersionUID = -2071565876962058344, 
 * local class serialVersionUID = -8345153069362641443
 *
 * Ϊʲô����������?//������д�������Ժ��޸���java�ļ�(ʵ������class�ļ�)���ٶ���ʱ���֡������ˡ�
 * 		Person��ʵ�������л��ӿڣ���ô������ҲӦ����һ�����ֵ��
 * 		������ֵ������100��
 * 		��ʼ��ʱ��
 * 		Person.class -- id=100
 * 		wirte���ݣ� oos.txt -- id=100
 * 		read����: oos.txt -- id=100	
 * 
 * 		���ڣ�
 * 		Person.class -- id=200
 * 		wirte���ݣ� oos.txt -- id=100
 * 		read����: oos.txt -- id=100
 * ������ʵ����˵�ľ��ǣ���Ϊ�����class�ļ�������class�ļ���Ӧ��idֵ�ͷ����˱仯������д��������û�б仯�ġ�����idֵ�ͻ᲻ͬ��
 * ������ʵ�ʿ����У����ܻ���Ҫʹ����ǰд�������ݣ���������д�롣��ô����?
 * ����һ��ԭ������Ϊ���ǵ�idֵ��ƥ�䡣
 * ÿ���޸�java�ļ������ݵ�ʱ��,class�ļ���idֵ���ᷢ���ı䡣
 * ����ȡ�ļ���ʱ�򣬻��class�ļ��е�idֵ����ƥ�䡣���ԣ��ͻ�����⡣
 * �����أ�������а취�������idֵ��java�ļ�����һ���̶���ֵ�����������޸��ļ���ʱ�����idֵ���ᷢ���ı���?
 * ���ᡣ���ڵĹؼ���������ܹ�֪�����idֵ��α�ʾ����?
 * ���õ��ģ��㲻�ü�ס��Ҳû��ϵ�������꼴�ɡ�
 * ���ѵ�û�п�����ɫ��������?
 * 
 * ����Ҫ֪�����ǣ�
 * 		������ʵ�������л��ӿڵ�ʱ��Ҫ������ɫ���������⣬�Ϳ����Զ�����һ�����л�idֵ��
 * 		���Ҳ������ֵ�Ժ����Ƕ�������κθĶ�������ȡ��ǰ��������û������ġ�!!!!!!!!!!!!!!
 * 
 * ע�⣺
 * 		��һ�����п����кܶ�ĳ�Ա��������Щ�Ҳ���������л�(ֵΪĬ��ֵ�����ᱻ��ֵ���ı�)�����ʸ���ô����?
 * 		ʹ��transient�ؼ�����������Ҫ���л��ĳ�Ա����
 */
public class Person implements Serializable {
	private static final long serialVersionUID = -2071565876962058344L;

	private String name;

	// private int age;

	private transient int age;
	//�ǲ�ס��֮ǰ���ֵ��

	// int age;

	public Person() {
		super();
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}
