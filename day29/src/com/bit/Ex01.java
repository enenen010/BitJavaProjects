package com.bit;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Ex01 {
public static void main(String[] args) {
	ServerSocket serv= new ServerSocket(8080);
	System.out.println("서버 준비..");
	Socket sock = serv.accept();
	os.write("");
	os.write();
	os.write();
	os.write();
	
	File f=new FIle("logo.jpg");
	InputStream is = new FileInputStream(f);
	
	
	os.close();
	sock.close();
	serv.close();
		
	
}
}
