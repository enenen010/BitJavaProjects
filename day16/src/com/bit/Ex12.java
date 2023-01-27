package com.bit;

import java.io.File;
import java.io.IOException;

public class Ex12 {
	
	
public static void main(String[] args) {
	//JVM 내에서 동작하므로 파일을 직접제어 하지 않음
    //있든없든 파일이란 객체는 만들어짐
	File f=new File("Lec02.txt");
	if(f.exists()) {
		System.out.println("존재합니다.");
	}else {
		System.out.println(f.hashCode()+"없습니다.");//존재안해도객체는생성(디폴트값0)
		//자바의 IO는 운영체제와의 소통이기에 Exception을 수반
		try {
			boolean boo=f.createNewFile();
			if(boo) System.out.println("파일생성");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
}
