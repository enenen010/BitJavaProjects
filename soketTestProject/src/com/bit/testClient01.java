package com.bit;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Scanner;
 
public class testClient01 {
    
    public static void main(String args[]) {
    
        try {
            
            // 서버 연결
            String serverIp = "127.0.0.1";
            System.out.println("IP :" + serverIp + "Server에 연결 중입니다.");
            
            // 소켓 생성
            Socket socket = new Socket(serverIp, 7777);
            
            // InputStram
            InputStream in = socket.getInputStream();
            DataInputStream dis = new DataInputStream(in);
            OutputStream os= socket.getOutputStream();
            DataOutputStream dos=new DataOutputStream(os);
            
            Scanner sc=new Scanner(System.in);
            // 데이터 출력
            while(true) {
            	System.out.print("명령>");
            	int request=sc.nextInt();
            	if(request==0)break;
            	
            	dos.writeInt(request);
            	
                System.out.println("Message :" + dis.readUTF());
            }
            
            
            // 스트림 및 소켓 종료
            dis.close();
            socket.close();
            System.out.println("연결 종료.");
            
        } catch (ConnectException ce) {
            ce.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


