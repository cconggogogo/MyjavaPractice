package cn.practice.Others._01_BasicJavaMethod.BZhan._11_JSON.json;

import cn.practice.Others._01_BasicJavaMethod.BZhan._11_JSON._01.Name;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class JSONDemo3 {
    /**
     * 创建JSON对象
     */
    @Test
    public void test(){
        List<Name> list = new ArrayList<>();
        list.add(new Name("vince","ma","565456@qq.com"));
        list.add(new Name("jack","wang","324324@qq.com"));
        JsonArray array = new JsonArray();
        for (Name n : list){
            JsonObject obj = new JsonObject();
            obj.addProperty("firstName",n.getFirstName());
            obj.addProperty("lastName",n.getLastName());
            obj.addProperty("email",n.getEmail());
            array.add(obj);
        }
        System.out.println(array.toString());
    }

    /**
     * GSON把对象转换为JSON：
     * 把一个JSON对象对象转换成java对象，
     * 或者把java对象转换成JSON对象
     *
     */
    @Test
    public void test2(){
        Gson gson = new Gson();
        InputStream is = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("cn/practice/Others/_01_BasicJavaMethod/BZhan/_11_JSON/json/name.json");
        InputStreamReader in = new InputStreamReader(is);
        Name name = gson.fromJson(in,Name.class);
        System.out.println("name: " + name);

        // 对象转换为JSON
        String string = gson.toJson(name);
        System.out.println("JSON: " + string);
    }

    /**
     * 把一组JSON对象转换为JAVA对象集合，或者把一个java集合转换为json数组
     */
    @Test
    public void test3(){
        Gson gson = new Gson();
        InputStream is = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("cn/practice/Others/_01_BasicJavaMethod/BZhan/_11_JSON/json/names.json");
        InputStreamReader in = new InputStreamReader(is);
        TypeToken<List<Name>> typeToken = new TypeToken<List<Name>>(){}; // 作用时指定泛型
        List<Name>  list = gson.fromJson(in, typeToken.getType());
        System.out.println("list： " + list);

        // 将对象转换为json
        String string = gson.toJson(list, typeToken.getType());
        System.out.println("JSON: " + string);
    }

}
