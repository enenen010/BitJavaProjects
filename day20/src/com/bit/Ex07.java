package com.bit;

import java.io.*;

public class Ex07 {
public static void main(String[] args) {
	
//	필터를 끼우면 크든 작튼 내부적으로 
//	원래 IO는 1바이트 스트림 그걸 이거처럼 
	
	Writer fw=null;
	PrintWriter pw=null;//이거 들어가보면 안에 Buffered쓰고있음
	
	try {
		//fw=new FileWriter(new File("test07.txt"));
		fw=new FileWriter("test07.txt");//위에꺼줄이는것도 만들어놈
		pw=new PrintWriter(fw);
		
		//print: 문자(문자열)로 작성하겠다는 뜻
		pw.print(true);
		pw.print(1234);
		pw.print(3.14);
		pw.println();
		pw.print("문자열 메시지 작성");
	} catch (IOException e) {
		e.printStackTrace();
	} finally {//사실 이렇게 했어야..
			try {
				if(pw!=null)pw.close();
				if(fw!=null)fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}	
	}
}
}
