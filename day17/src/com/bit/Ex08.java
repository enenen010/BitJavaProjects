package com.bit;
import java.io.*;
public class Ex08 {
public static void main(String[] args) {
	//유일하게 쌍으로 존재하지 않는 java.io
	
//	PrintStream out=System.out; -> System.out.println(); 
//	사실 System.out을 상속받는 PrintStream 이었음
	
//	여기까지 DataStream빼고 모든 언어 공용
	
	File f=new File("lec06.bin");
	OutputStream os=null;
	PrintStream ps=null;
	try {
		os=new FileOutputStream(f);
		ps=new PrintStream(os);
		//이어쓰기
		ps.print("abcdefg");
		ps.print(1234);//뭘입력하든 toStirng 읽을떄 문자, 문자열로
		
		
		if(ps!=null)ps.close();
		if(os!=null)os.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}
