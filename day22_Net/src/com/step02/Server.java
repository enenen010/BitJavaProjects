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

public class Server {
public static void main(String[] args) {
	Socket sock=null;
	ServerSocket serve=null;
	OutputStream os=null;
	InputStream is=null;
	InputStreamReader isr=null;
	OutputStreamWriter osw=null;
	BufferedReader br=null;
	PrintWriter	pr=null;
	
	
	InetAddress inet=null;
	
	//서버주소, 들어올문(포트)
	//열어놀문(포트)만    주소는이미나임
	try {
		serve=new ServerSocket(8080);
		sock=serve.accept();//소켓받음
		os=sock.getOutputStream();
		is=sock.getInputStream();
		isr=new InputStreamReader(is);
		osw=new OutputStreamWriter(os);
		br=new BufferedReader(isr);
		pr=new PrintWriter(osw);
		
		String msg=null;
		while((msg=br.readLine())!=null) {
			pr.println(msg);
			pr.flush();
		}
		
		if(pr!=null)pr.close();
		if(br!=null)br.close();
		if(osw!=null)osw.close();
		if(isr!=null)isr.close();
		if(os!=null)os.close();
		if(is!=null)is.close();
		if(sock!=null)sock.close();
		if(serve!=null)serve.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}
