package com.bit;
import java.io.*;
public class Ex11 {
public static void main(String[] args) {
	//자바를 벗어나게되면 문자열 스트림 지원 안할 수 있음
	//바이트스트림은 어디서나 지원하니 잘 이해하자
	InputStream is=null;
	Reader isr=null;
	try {
		is=new FileInputStream("");
		isr=new InputStreamReader(is);
		int su=-1;
		while((su=isr.read())!=-1) {
			System.out.println((char)su);
		}
		if(isr!=null)isr.close();
		if(is!=null)is.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
}
}
