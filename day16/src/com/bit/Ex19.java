package com.bit;
import java.io.*;
public class Ex19 {
public static void main(String[] args) {
	String msg="java world";
	byte[] arr=msg.getBytes();
	InputStream is=System.in;
	OutputStream os=System.out;
	int su=-1;
	//13==\r
	//10==\n
	try {
//		for(int i=0;i<arr.length;i++) {
//			su=is.read();
//			os.write(su);
//		}
		//문제생김
		while(true) {
			su=is.read();
			if(su==-1)break;
			os.write(su);
		}
		is.close();
		os.close();
	}catch(IOException e) {
		e.printStackTrace();
	}
}
}
