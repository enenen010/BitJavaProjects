package com.bit;
import java.io.IOException;
import java.net.*;
import java.util.Arrays;
public class Receiver {
public static void main(String[] args) {
//	이건 UDP 방식   서버, 클라이언트라는 개념 자체가 없음
//	일반적으로 Sender가 굳이 따지자면 서버가 되는거임
	
//	보내는 쪽과 받는 쪽의 형식(길이,자료형 등)이 달라 생기는 문제점들
//	Receiver는 Sender가 어떤 형식으로 보낼지 이미 알고 있어야함(=그렇게 보내게 만들어라, 제약)
	
//	한 프로세스 당 무조건 포트 1개: 사실 당연 포트가 프로세스 구분할려고 쓰는건데(고정포트(서버),유동포트(클라))
	DatagramSocket sock=null;
	DatagramPacket packet=null;
//	byte[] buf=new byte[4];
	byte[] buf=new byte[16];
	try {
		//0~1024까지는 옛날부터, 2000번 등 이미 점유하고 있는 프로그램이 있음 최대한 피할것
		//같은 포트를 사용하는 프로그램이 한 컴퓨터에서 동시에 동작하면 문제가 생기기 때문
		sock=new DatagramSocket(8080);
//		while(true)
		//1.
		packet=new DatagramPacket(buf, 4);
		sock.receive(packet);
		buf=packet.getData();
		System.out.println(Arrays.toString(buf));
		System.out.println(new String(buf));
		
		//2.
		packet=new DatagramPacket(buf, 4);
		sock.receive(packet);
		buf=packet.getData();
		System.out.println(Arrays.toString(buf));
		System.out.println(new String(buf));
		
		
		if(sock!=null)sock.close();
	} catch (SocketException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
}
}
