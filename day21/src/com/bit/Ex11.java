package com.bit;

import java.util.*;
import java.io.*;

//동기화 필요: 자료구조는 이미 동기화 다 했다고 했음
class Lec11 implements Serializable{
	//쓸때 기본적으로 자동으로 시리얼 번호 붙음
	//서로다른 버전은 읽을 수 없음 =>수정하면 어떻게 읽으라는 거냐 표시해라..
	//지정할수도 있음
	
	//필드만 동기화Serializable 대상
	private static final long serialVersionUID = 1L;
	int su1=1234;
	transient int su2=1234;//이건 안보낼래
	int su3=1234;
	
	//메서드는 동시사용
//	사실 객체는 메서드 내용없이 어떤메소드 쓰는지만 알고있음
//	(가능하려면 함수가 타입이 되야함) 자바는 하고싶었지만 못했고 자바스크립트는 완성 (함수가 타입)
//	동기화를 해도 타고들어간 내용이 1개라 바뀐거밖에 안보임
	public void func() {
		System.out.println("func go...");
	}
}



public class Ex11{
public static void main(String[] args) {
	OutputStream os=null;
	ObjectOutputStream oos=null;
	try {
		
		os=new FileOutputStream("data11.bin");
		oos=new ObjectOutputStream(os);
		Lec11 lec=new Lec11();
		oos.writeObject(lec);
		if(oos!=null)oos.close();
		if(os!=null)os.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
}
}
