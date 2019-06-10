package cn.practice.Others._01_BasicJavaMethod.BZhan._10_XML_JSON._03;

import cn.practice.Others._02_BZhan._10_XML_JSON._01.Person;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * jdom解析SAX：
 * 与DOM类似都是基于树形结构
 *
 * 与DOM的区别：
 * 第三方的开源组件；
 * 实现使用java的collection接口
 * 效率比dom更快
 */
public class XMLDemo {
    @Test
    public void test() throws JDOMException, IOException {
        // 创建jdom解析器
        SAXBuilder saxBuilder = new SAXBuilder();
        InputStream is = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream("cn/practice/Others/_01_BasicJavaMethod/BZhan/_10_XML_JSON/_01/people.xml");
        Document build = saxBuilder.build(is);
        // 获得根节点
        Element rootElement = build.getRootElement();
        List<Person> list = new ArrayList<>();
        Person p = null;
        // 获得People的孩子结点的集合(两个person结点)
        List<Element> children = rootElement.getChildren();
        // 遍历孩子结点的集合
        for (Element element: children){
            p = new Person();
            String personid = element.getAttributeValue("personid");
            p.setPersonid(personid);
            // person的孩子结点
            List<Element> children1 = element.getChildren();
            for (Element e:children1){
                String tag = e.getName();
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
            list.add(p);
        }
        System.out.println("res: ");
        System.out.println(Arrays.toString(list.toArray()));
    }
}
