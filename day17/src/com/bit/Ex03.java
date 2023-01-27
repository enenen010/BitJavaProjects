package com.bit;

import java.io.*;

public class Ex03 {
	// 한쪽에서 필터를 쓰면 반대쪽도 필터를 써야한다?
	// no 결국 바이트다 좀 불편할 뿐 자료형 알고있으면 가능
	// 인코딩과 같다 utf8 로 적었으면 utf8로 읽듯 int로적었으면 int로읽기

	// Ex01,02 사용자정의 버퍼
	// 이젠 필터클래스가 제공하는 버퍼
	public static void main(String[] args) {
		String msg="ABCDEFG HIJKLMN";
		File f=new File("lec03.bin");
		OutputStream os;
		BufferedOutputStream bos=null;
		try {
			if(f.exists())f.createNewFile();
			os=new FileOutputStream(f);
			bos=new BufferedOutputStream(os);
			for(int i=0;i<msg.length();i++) {
				bos.write(msg.charAt(i));
			}
			if(bos!=null)bos.close();
			if(os!=null)os.close();
			System.out.println("끝");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
