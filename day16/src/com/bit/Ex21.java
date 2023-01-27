package com.bit;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Ex21 {
public static void main(String[] args) {
	String msg="버퍼를 달아서 성능 올리기";
	byte[] arr=msg.getBytes();
	File f=new File("Lec21.txt");
	OutputStream os;
	
//	File target = new File("logo.jpg");
//	File result = new File("copy.jpg");

	try {
		if (f.exists()) {
			f.createNewFile();
			os = new FileOutputStream(f);
			os.write(arr);
			os.close();
		}
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}
//고용량은 겁나오래걸림 1바이트씩 끊어서..
//횟수줄임, 효율적 작업