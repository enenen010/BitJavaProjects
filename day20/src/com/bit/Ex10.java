package com.bit;

import java.io.*;

public class Ex10 {
public static void main(String[] args) {
	OutputStream os=null;
	OutputStreamWriter osw=null;
	
	try {
		os=new FileOutputStream("test08.txt");
		osw=new OutputStreamWriter(os);
		
		osw.write("문자를 작성합니다.");
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}
