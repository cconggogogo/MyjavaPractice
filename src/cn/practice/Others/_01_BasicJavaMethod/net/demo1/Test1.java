package cn.practice.Others._01_BasicJavaMethod.net.demo1;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test1 {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getByName("192.168.0.82");
        System.out.println("hostname: " + inetAddress.getHostName());
        System.out.println("hostaddress: " + inetAddress.getHostAddress());
    }
}
