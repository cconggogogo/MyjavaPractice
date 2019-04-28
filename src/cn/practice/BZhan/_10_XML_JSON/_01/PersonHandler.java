package cn.practice.BZhan._10_XML_JSON._01;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * SAX解析的特点：
 * 基于事件驱动；
 * 顺序读取，速度快；
 * 不能任意读取结点(灵活性差)
 * 更适用于性能要求更高的设备，比如安卓
 * 解析时占用的内存小，适用于移动设备
 */
public class PersonHandler extends DefaultHandler {
    private List<Person> persons = null;
    private Person person; // 当前正在解析的对象
    private String tag; // 用于记录正在解析的标签名

    public List<Person> getPersons() {
        return persons;
    }

    // 开始解析文档时使用
    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        persons = new ArrayList<>();
        System.out.println("开始解析文档");
    }

    // 解析结束时调用
    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        System.out.println("解析文档结束");
    }

    // 解析开始元素时调用

    /**
     *
     * @param uri 命名空间，很像包
     * @param localName 不带前缀的标签名<person...
     * @param qName 带前缀的标签名<aa: person...
     * @param attributes 当前标签的属性集合
     * @throws SAXException
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if ("person".equals(qName)){
            person = new Person();
            String personid = attributes.getValue("personid");
            person.setPersonid(personid);
        }
        tag = qName;
        System.out.println("startElement:" + qName);
    }

    // 解析结束元素时调用
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if ("person".equals(tag)){
            persons.add(person);
        }
        tag = null;
        System.out.println("endElement:" + qName);
    }

    // 解析到标签中的内容时
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        if (tag != null) {
            if ("name".equals(tag)) {
                person.setName(new String(ch,start,length));
            } else if ("address".equals(tag)){
                person.setAddress(new String(ch,start,length));
            } else if ("tel".equals(tag)){
                person.setTel(new String(ch,start,length));
            } else if ("email".equals(tag)){
                person.setEmail(new String(ch,start,length));
            } else if ("fax".equals(tag)){
                person.setFax(new String(ch,start,length));
            }
        }
    }
}
