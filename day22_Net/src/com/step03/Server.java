package com.step03;

import java.io.*;
import java.net.*;

public class Server extends Thread{
	Socket sock;
	public Server(Socket sock) {
		
	}

	@Override
	public void run() {

		InputStream is = null;
		OutputStream os = null;
		

		try {
			is=sock.getInputStream();
			os=sock.getOutputStream();
			while(true) {
				int su=is.read();
				if(su==-1)break;
				os.write(su);
			}

			if (os != null)os.close();
			if (is != null)is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
	
public static void main(String[] args) {
	Socket sock=null;
	ServerSocket serve=null;
	OutputStream os=null;
	InputStream is=null;
	InputStreamReader isr=null;
	OutputStreamWriter osw=null;
	BufferedReader br=null;
	PrintWriter	pr=null;
	
	
	
	
//	//서버주소, 들어올문(포트)
//	//열어놀문(포트)만    주소는이미나임
//	try {
//		serve=new ServerSocket(8080);
//		while(true) {
//			sock=serve.accept();//소켓받음
//			InputStream is1=sock.getInputStream();
//			OutputStream os1=sock.getOutputStream();
//			//여기만 계속돌음 소켓 못만듬
//			//일을 못함
//			while(true) {
//				int su=is.read();
//				if(su==-1)break;
//				os.write(su);
//			}
//		}
//		//결국 소켓만드는 쓰레드,IO하는 쓰레드 따로 있어야함 (무한루프는 다따로 쓰레드) 
//		
//
////		if(os!=null)os.close();
////		if(is!=null)is.close();
////		if(sock!=null)sock.close();
////		if(serve!=null)serve.close();
//	} catch (IOException e) {
//		e.printStackTrace();
//	}
	
	
	try {
		serve=new ServerSocket(8080);
		while(true) {
			sock=serve.accept();//소켓받음
			Server me=new Server(sock);
		}
		//결국 소켓만드는 쓰레드,IO하는 쓰레드 따로 있어야함 (무한루프는 다따로 쓰레드) 
		
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	
}
}
