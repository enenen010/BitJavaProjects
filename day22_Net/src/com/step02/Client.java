package com.step02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {
public static void main(String[] args) {
	String url="127.0.0.1";
	int port1=8080;
	Socket sock=null;
	//버퍼없이 바로전송
	OutputStream os=null;
	InputStream is=null;
	
	//버퍼를 사용
	InputStreamReader isr=null;
	OutputStreamWriter osw=null;
	BufferedReader br=null;
	PrintWriter	pr=null;
	Scanner sc=new Scanner(System.in);
	
	try {
		sock=new Socket(url,port1);
		
		is=sock.getInputStream();
		os=sock.getOutputStream();
		isr=new InputStreamReader(is);
		osw=new OutputStreamWriter(os);
		br=new BufferedReader(isr);
		pr=new PrintWriter(osw);
		
		
		String msg=null;
		while(true) {
			System.out.print(">");
			msg=sc.nextLine();
			if(msg.equals("end"))break;
			pr.println(msg);
			pr.flush();//버퍼를 쓴다는 건 close때 한번에 나간다는거
			msg=br.readLine();
			System.out.println(msg);
		}
	
		
		
		if(pr!=null)pr.close();
		if(br!=null)br.close();
		if(osw!=null)osw.close();
		if(isr!=null)isr.close();
		if(os!=null)os.close();
		if(is!=null)is.close();
		if(sock!=null)sock.close();
	} catch (IOException e) {//통신도IO
		e.printStackTrace();
	}
}
}
