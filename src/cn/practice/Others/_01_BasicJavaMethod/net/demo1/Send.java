package cn.practice.Others._01_BasicJavaMethod.net.demo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class Send {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while ((line = br.readLine())!=null){
            if ("886".equalsIgnoreCase(line)){
                break;
            }
            byte[] bys = new byte[1024];
            DatagramPacket dp = new DatagramPacket(bys,bys.length, InetAddress.getByName("192.168.0.82"),10086);
            datagramSocket.send(dp);
        }
        datagramSocket.close();
    }
}
