package com.bit;
import java.io.IOException;
import java.net.*;
public class Sender {
public static void main(String[] args) {
	DatagramSocket sock=null;
	DatagramPacket packet=null;
	InetAddress addr=null;
	byte[] arr= {127,0,0,1};
	try {
		addr=InetAddress.getByAddress(arr);
		sock=new DatagramSocket();
//		sock=new DatagramSocket(8080,addr); 이거말고  ▽에 실어서 보냄
		packet=new DatagramPacket("abcd".getBytes(),4,addr,8080);
		sock.send(packet);
		
		packet=new DatagramPacket("efgd".getBytes(),4,addr,8080);
		sock.send(packet);
		
		if(sock!=null)sock.close();
	} catch (SocketException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
}
}
