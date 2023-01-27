package com.bit;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.text.SimpleDateFormat;

public class testServer01 {
	private static final int PORT = 7777;
    public static void main(String[] args) {
    	
    	// 소켓서버가 종료될때까지 무한루프
    	try {
    		// 서버소켓 생성
    		ServerSocket serverSocket = new ServerSocket(PORT);

    		while(true){
				// 소켓 접속 요청이 올때까지 대기합니다.
				Socket socket = serverSocket.accept();
				// 응답을 위해 스트림을 얻어옵니다.
				OutputStream os = socket.getOutputStream();
				try{
					// 그리고 현재 날짜를 출력해줍니다.
					os.write(new Date().toString().getBytes());
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					// 반드시 소켓은 닫습니다.
					os.close();
					socket.close();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
        
    }
    static String getTime() {
        SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
        return f.format(new Date());
    }
 
}

