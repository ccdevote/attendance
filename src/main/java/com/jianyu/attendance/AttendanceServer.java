package com.jianyu.attendance;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.lang.String;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;


public class AttendanceServer{
    public static final int SERVER_PORT=2010;
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        try{
            ServerSocket atServer= new ServerSocket(SERVER_PORT);
            System.out.println("Listening Port is "+atServer.getLocalPort()+"...");
            while(true){
                Socket atClient=atServer.accept();
                System.out.println("have a client entering , the IP is "+atClient.getInetAddress()+"...");
                System.out.println("have a client entering , the Port is "+atClient.getPort()+"...");
                new GetGpsThreadFun(atClient).start();
            }
            //vntClient.close();

        }catch (Exception e) {
            // TODO: handle exception

            e.printStackTrace();
        }
    }
}
class GetGpsThreadFun extends Thread{
    private Socket atThreadClient;
    public GetGpsThreadFun(Socket vntThreadSocket){
        atThreadClient=atThreadSocket;
    }
    public void run(){
        try{
            BufferedReader atThreadIS=new BufferedReader(new InputStreamReader(atThreadClient.getInputStream()));
            while(true){
                String atReceiveString=atThreadIS.readLine();
                if (atReceiveString!=null){
                    System.out.println(atThreadClient.getInetAddress()+":"+atThreadClient.getPort()+":"+atReceiveString);
                }
                if("query".equals(atReceiveString)){
                    FileReader fr = new FileReader("~/tmp/attendance.txt");
                    BufferedReader br = new BufferedReader(fr);
                    Map<String,AttendInfo> map = new HashMap<String, AttendInfo>();
                    String data =br.readLine();
                    while(data!=null){
                        StringTokenizer tokenizer = new StringTokenizer(data);
                        while(tokenizer.hasMoreTokens()){
                            AttendInfo ai = new AttendInfo();
                            ai.set
                        }
                    }


                }
                if("shutdown".equals(atReceiveString)){
                    break;
                }
            }
            atThreadIS.close();
            atThreadClient.close();
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
