package com.step01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
public static void main(String[] args) {
	byte[] arr= {(byte)127,(byte)0,(byte)0,(byte)1};
	InetAddress addr=null;
	int port=8080;
	InputStream is=null;
	OutputStream os=null;
	
	java.net.Socket sock=null;
	try {
		addr=InetAddress.getByAddress(arr);
		
		
		//IOException과
		//객체의 생성이 곹 접속-> 접속할소켓이 미리 만들어지고
		//그것이 연결된 소켓 객체가 반환되어야함->누구?서버소켓!!
		sock=new Socket(addr,port);
		is=sock.getInputStream();
		os=sock.getOutputStream();
		
//		문제없음
		os.write(65);
		System.out.println(is.read());
		os.write(66);
		System.out.println(is.read());
		os.write(67);
		System.out.println(is.read());
		
		os.write(65);
		os.write(66);
		os.write(67);
		System.out.println(is.read());
		System.out.println(is.read());
		System.out.println(is.read());
		System.out.println(is.read());
		System.out.println(is.read());
		System.out.println(is.read());
		System.out.println(is.read());
		System.out.println(is.read());
		System.out.println(is.read());
		System.out.println(is.read());
		System.out.println(is.read());
		
		
		
////		문제: 읽어올게 없다는 걸 어떻게
//		os.write("Hi server....".getBytes());
//		
//		int su=-1;
////		while((su=is.read())!=-1) {
//		while((su=is.read())!='.') {
//			System.out.print((char)su);
//		}
		
//		우아한 종료: 자바엔 없음 종료시그널 못보내서
		
		
		if(os!=null)os.close();
		if(is!=null)is.close();
		if(sock!=null)sock.close();
	} catch (IOException e) {//통신도IO
		e.printStackTrace();
	}
	
}
}
