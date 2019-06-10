package cn.practice.Others._01_BasicJavaMethod.BZhan._10_XML_JSON._05;

import cn.practice.Others._02_BZhan._10_XML_JSON._01.Person;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Xpp3Driver;
import org.junit.Test;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;


public class XMLEncoderDemo {
    /**
     * 把对象转换为xml：
     *
     */
    @Test
    public void test() throws FileNotFoundException {
        BufferedOutputStream bos = new BufferedOutputStream(
                new FileOutputStream("test.xml"));
        XMLEncoder xmlEncoder = new XMLEncoder(bos);
        Person person = new Person();
        person.setPersonid("546");
        person.setName("name");
        person.setEmail("email");
        person.setFax("fax");
        person.setTel("tel");
        xmlEncoder.writeObject(person);
        xmlEncoder.close();
    }

    /**
     * 从xml读取对象
     */
    @Test
    public void test2() throws FileNotFoundException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("test.xml"));
        XMLDecoder decoder = new XMLDecoder(bis);
        Person person = (Person)decoder.readObject();
        System.out.println(person);
    }

    /**
     * 使用第三方的xstream组件实现xml的解析与生成
     * 将对象转换为xml格式输出
     *
     * 包可能有点问题
     */
    @Test
    public void test3(){
        Person person = new Person();
        person.setPersonid("546");
        person.setName("name");
        person.setEmail("email");
        person.setFax("fax");
        person.setTel("tel");

        // 对象转换为xml
        XStream xStream = new XStream(new Xpp3Driver());
        xStream.alias("person",Person.class);
        xStream.useAttributeFor(Person.class,"personid");
        String xml = xStream.toXML(person);
        System.out.println(xml);

        // 解析xml
        Person person1 = (Person) xStream.fromXML(xml);
        System.out.println(person1);
    }
}
