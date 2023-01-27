package com.step01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
public static void main(String[] args) {
	Socket sock=null;
	ServerSocket serve=null;
	InetAddress inet=null;
	OutputStream os=null;
	InputStream is=null;
	//서버주소, 들어올문(포트)
	//열어놀문(포트)만    주소는이미나임
	try {
		serve=new ServerSocket(8080);
		sock=serve.accept();
//		sock.getInetAddress();
//		inet=sock.getInetAddress();
//		System.out.println(inet.getHostName()+"클라이언트 요청 받음");
		
//		CS프로그램: 서버 프로그램(서버시점)
//		os.write("Hello Client....".getBytes());
		os=sock.getOutputStream();
		is=sock.getInputStream();
		int su=-1;
		while((su=is.read())!=-1) {
//			System.out.print((char)su);
			os.write(su);
		}
		
		if(sock!=null)sock.close();
		if(sock!=null)sock.close();
		if(sock!=null)sock.close();
		if(serve!=null)serve.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}
