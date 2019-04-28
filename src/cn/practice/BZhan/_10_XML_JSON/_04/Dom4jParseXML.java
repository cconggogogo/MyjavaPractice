package cn.practice.BZhan._10_XML_JSON._04;

import cn.practice.BZhan._10_XML_JSON._01.Person;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * DOM4J解析XML:
 *
 * 基于树形结构，第三方组件；
 * 解析速度快，效率更高，使用的java中的迭代器实现数据读取，
 * 在web应用中使用更多(hibernate);
 *
 */
public class Dom4jParseXML {
    @Test
    public void test() throws DocumentException {
        SAXReader reader = new SAXReader();
        InputStream is = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream("cn/practice/BZhan/_10_XML_JSON/_01/people.xml");
        Document doc = reader.read(is);
        // 根节点
        Element rootElement = doc.getRootElement();
        // 获得迭代器对象
        Iterator iterator = rootElement.elementIterator();
        ArrayList<Person> persons = new ArrayList<>();
        Person p = null;
        // 遍历迭代器(两个person结点)
        while (iterator.hasNext()){
            p = new Person();
            Element e = (Element) iterator.next();
            p.setPersonid(e.attributeValue("personid"));
            // 获得person的子节点
            Iterator iterator1 = e.elementIterator();
            while (iterator1.hasNext()){
                Element next = (Element) iterator1.next();
                String tag = next.getName();
                if ("name".equals(tag)){
                    p.setName(e.getText());
                } else if ("address".equals(tag)){
                    p.setAddress(e.getText());
                } else if ("tel".equals(tag)){
                    p.setTel(e.getText());
                } else if ("fax".equals(tag)){
                    p.setFax(e.getText());
                } else if ("email".equals(tag)){
                    p.setEmail(e.getText());
                }
            }
            persons.add(p);
        }
        System.out.println("res: ");
        System.out.println(Arrays.toString(persons.toArray()));
    }
}
