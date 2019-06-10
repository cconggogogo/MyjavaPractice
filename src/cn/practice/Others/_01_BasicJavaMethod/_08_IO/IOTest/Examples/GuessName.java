package cn.practice.Others._01_BasicJavaMethod._08_IO.IOTest.Examples;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class GuessName {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("newFile.txt"));
        ArrayList<String> arrayList = new ArrayList<>();
        String line = null;
        while ((line = br.readLine()) != null) {
            arrayList.add(line);
        }
        Random random = new Random();
        int index = random.nextInt(arrayList.size());
        System.out.println(arrayList.get(index));
    }
}
