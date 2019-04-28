package cn.practice.BZhan._10_XML_JSON._01;

import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class XMLDemo {
    @Test
    public void test() throws ParserConfigurationException, SAXException, IOException {
        // 常 见一个SAX解析器工厂对象
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        // 通过工厂对象创建SAX解析器
        SAXParser saxParser = saxParserFactory.newSAXParser();

        // 创建一个数据处理器(需要自己来编写)
        PersonHandler personHandler = new PersonHandler();

        InputStream is = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("cn/practice/BZhan/_10_XML_JSON/_01/people.xml");

        saxParser.parse(is,personHandler);

        List<Person> persons = personHandler.getPersons();

        for (Person person: persons){
            System.out.println(person);
        }
    }

    @Test
    public void test2(){
        System.out.println("你好吗");
    }
}
