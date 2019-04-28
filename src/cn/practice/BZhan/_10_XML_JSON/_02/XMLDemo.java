package cn.practice.BZhan._10_XML_JSON._02;

import cn.practice.BZhan._10_XML_JSON._01.Person;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * DOM解析XML文档：
 * 基于树形结构，通过解析器一次性把文档加载到内存中，比较耗费内存，可以随机访问，
 * 更加灵活，更适合在web开发中使用；
 */
public class XMLDemo {
    @Test
    public void test() throws ParserConfigurationException, IOException, SAXException {
        // 创建一个DOM解析器工厂对象
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        // 通过工厂对象创建解析器对象
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        // 解析文档
        InputStream is = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("cn/practice/BZhan/_10_XML_JSON/_01/people.xml");

        // 此代码完成之后，整个XML文档已经被加载到内存中，以树形形式存储
        Document doc = documentBuilder.parse(is);

        // 从内存中读取数据
        // 获取结点名称为person的所有结点，返回结点集合
        NodeList personNodeList = doc.getElementsByTagName("person");
        ArrayList<Person> persons = new ArrayList<>();
        Person p = null;
        for (int i = 0; i<personNodeList.getLength();i++){
            Node node = personNodeList.item(i);
            p = new Person();
            String personid = node.getAttributes().getNamedItem("personid").getNodeValue();
            p.setPersonid(personid);
            NodeList childNodes = node.getChildNodes();
            for (int j = 0; j<childNodes.getLength();j++){
                Node item = childNodes.item(j);
                String nodeName = item.getNodeName();
                if ("name".equals(nodeName)){
                    p.setName(item.getFirstChild().getNodeValue());
                } else if ("address".equals(nodeName)){
                    p.setAddress(item.getFirstChild().getNodeValue());
                } else if ("tel".equals(nodeName)){
                    p.setTel(item.getFirstChild().getNodeValue());
                } else if ("fax".equals(nodeName)){
                    p.setFax(item.getFirstChild().getNodeValue());
                } else if ("email".equals(nodeName)) {
                    p.setEmail(item.getFirstChild().getNodeValue());
                }
            }
            persons.add(p);
        }
        System.out.println("result:");
        System.out.println(Arrays.toString(persons.toArray()));
    }
}
