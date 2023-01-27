package com.bit;

import java.io.*;

public class Ex04 {
public static void main(String[] args) {
	File f=new File("test03.txt");
	Reader fr=null;
	char[] buff=new char[8];//2바이트단위처리이므로 char=2byte형식
	try {
		fr=new FileReader(f);
		
		int su;
		while((su=fr.read(buff))!=-1) {
			
			String msg=new String(buff,0,su);
			System.out.print(msg);
		}
		
		
		if(fr!=null)fr.close();
	}catch(IOException e) {
		e.printStackTrace();
	}
	
}
}
