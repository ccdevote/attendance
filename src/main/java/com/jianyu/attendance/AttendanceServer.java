package com.jianyu.attendance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.String;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;


public class AttendanceServer {

    private static final int SERVER_PORT = 2010;
    private static final String PATH = "~/attend.txt";

    public static void main(String[] args) {
        ServerSocket atServer = null;
        try {
            atServer = new ServerSocket(SERVER_PORT);
            System.out.println("Listening Port is " + atServer.getLocalPort() + "...");
            while (true) {
                Socket atClient = atServer.accept();
                System.out.println("have a client entering , the IP is " + atClient.getInetAddress() + "...");
                System.out.println("have a client entering , the Port is " + atClient.getPort() + "...");
                new GetGpsThreadFun(atClient).start();
            }
            //vntClient.close();
        } catch (Exception e) {
            System.err.println("error in bootstrap server");
            e.printStackTrace();
        } finally {
            try {
                atServer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class GetGpsThreadFun extends Thread {
        private Socket atThreadClient;

        public GetGpsThreadFun(Socket vntThreadSocket) {
            atThreadClient = vntThreadSocket;
        }

        public void run() {
            BufferedReader atThreadIS = null;
            try {
                atThreadIS = new BufferedReader(new InputStreamReader(atThreadClient.getInputStream()));
                while (true) {
                    String atReceiveString = atThreadIS.readLine();
                    if (atReceiveString != null) {
                        System.out.println(atThreadClient.getInetAddress() + ":" + atThreadClient.getPort() + ":" + atReceiveString);
                    }
                    if ("query".equals(atReceiveString)) {
                        List<String> list = FileUtils.read(AttendanceServer.PATH);
                        List<AttendanceInfo> infos= AttendanceInfo.parseToAttendanceList(list);
                        //TODO AttendanceSort.sort(infos);
                        //TODO print infos
                    } else if ("shutdown".equals(atReceiveString)) {
                        break;
                    } else {
                        FileUtils.wirte(AttendanceServer.PATH,atReceiveString);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                try {
                    atThreadIS.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally{
                    try {
                        atThreadClient.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}

