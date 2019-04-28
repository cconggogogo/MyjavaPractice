package cn.practice.BZhan._11_JSON.json;

import cn.practice.BZhan._11_JSON._01.Message;
import cn.practice.BZhan._11_JSON._01.User;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 使用jsonreader解析复杂的json对象
 */
public class JSONDemo2 {
    @Test
    public void test(){
        InputStream is = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("cn/practice/BZhan/_11_JSON/json/message.json");
        InputStreamReader in = new InputStreamReader(is);
        // JSON的解析工具(解析器)
        JsonReader reader = new JsonReader(in);
        ArrayList<Message> messages = readMessageArray(reader);
        for (Message m : messages){
            System.out.println(m);
        }
    }

    // 读取message数组
    private ArrayList<Message> readMessageArray(JsonReader reader) {
        ArrayList<Message> list = new ArrayList<>();
        try {
            reader.beginArray(); // 花括号
            while (reader.hasNext()){
                list.add(readMessage(reader));
            }
            reader.endArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private Message readMessage(JsonReader reader) {
        Message message = new Message();
        try {
            reader.beginObject(); // 具体属性，不是数组了
            while (reader.hasNext()){
                String name = reader.nextName();
                if ("id".equals(name)){
                    message.setId(reader.nextLong());
                } else if ("text".equals(name)){
                    message.setText(reader.nextString());
                } else if ("geo".equals(name)&&reader.peek()!= JsonToken.NULL){
                    message.setGeo(readGeo(reader));
                } else if ("user".equals(name)){
                    message.setUser(readUser(reader));
                } else {
                    // 不成立就跳过
                    reader.skipValue();
                }

            }
            reader.endObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return message;
    }

    /**
     * 解析User
     * @return
     */
    private User readUser(JsonReader reader) {
        User user = new User();
        try {
            reader.beginObject();
            while (reader.hasNext()){
                String name = reader.nextName();
                if ("name".equals(name)){
                    user.setName(reader.nextString());
                } else if ("followers_count".equals(name)){
                    user.setFollowers_count(reader.nextInt());
                }
            }
            reader.endObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * 解析geo数组
     * @return
     */
    private ArrayList<Double> readGeo(JsonReader reader) {
        ArrayList<Double> list = new ArrayList<>();
        try {
            reader.beginArray();
            while (reader.hasNext()){
                list.add(reader.nextDouble());
            }
            reader.endArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
