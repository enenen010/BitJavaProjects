package com.bit;

import java.io.*;

public class Ex02 {
	
public static void main(String[] args) {
	File f=new File("test01.txt");
	
	InputStream is=null;
	
//	1,2,3바이트 끊어읽기를 위해 일단 바이트 배열로 만들고싶을때
//	ByteArrayStream은 값을 자기공간(메모리)에 저장하고 그것을 Byte[]로 반환
//	Byte값을 Byte[]로써 임시적으로 저장해 사용하는 것이 목적
//	읽음과 동시에 Byte[]할당이 일어나므로 성능향상, 편의성 제공
//	이전 파일에서 덮어쓸때  임시적으로 전내용파일에 썻는데
//	하드디스크라서 느림 이건 메모리라서 빠름
//	뒤에서 배울 누적이라는게 이게 베이스
//	뒤에서 배울것을 이해하는 것에 의의가 있다.
//	
//	 ByteArrayInputStream과 같이 메모리를 사용하는 스트림과
//	System.in, System.out과 같은 표준입출력 스트림은 닫아주지 않아도 된다.
	
	ByteArrayOutputStream baos=null;
	ByteArrayInputStream bais=null;
	try {
		//처음예제 파일가지고 다룸 하드디스크
		//파일다루기, 자료구조보다 빠름 제일빠름
		is=new FileInputStream(f);
		
//		생성자에 매개변수 필요없는 이유
//		:IO는 밖과 프로그램 내부의 소통이다
//		ByteArrayInputstream의경우 외부의 값을 byte[]지만
//		output의 경우 내부에서 내부byte[]기에 따로 필요없다
//		즉 스트림의 매개변수는 외부와 소통이 필요할때 사용한다
		baos=new ByteArrayOutputStream();
		
		int su=-1;
		while((su=is.read())!=-1) {
			baos.write(su);//byte[]로 write
		}
		byte[] arr=baos.toByteArray();
		System.out.println(new String(arr));
		if(baos!=null)baos.close();
		if(is!=null)is.close();
	}catch(FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}
