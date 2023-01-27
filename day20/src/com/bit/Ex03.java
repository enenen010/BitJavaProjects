package com.bit;

import java.io.*;

public class Ex03 {
public static void main(String[] args) {
	File f=new File("test03.txt");
	Writer pw=null;
	
//	문자열 스트림 
//	2바이트 체계제공 사실 안쪽에서 2바이트로 처리
//	결국 최후에는 바이트스트림 사용함
//	오직 문자, 문자열을 쓰기위한 목적
//	다른 자료형처리하면 문제생김 무조건 2바이트씩 처리해서
//	byteStream이 문자열처리할때 .getByte해서 하는건 목적이 데이터라서
	
		try {
			if(f.exists())f.createNewFile();
			pw=new FileWriter(f);
			
			pw.write('\uac00');//기본 char혹은 char[]
			pw.write("잘 들어 가셨는가?");//오버로딩
			
//			그냥 stream은 close그래도 어느정도 써졌는데 
//			buffed나 이건 안써짐  
			if(pw!=null)pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
}
}
