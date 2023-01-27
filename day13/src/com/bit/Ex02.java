package com.bit; //이 클래스가 어느 패키지에 있는지 정의
import com.bit2.Ex01;//내부에서 외부클래스를 호출했을때 어느 패키지에 있는지 명세
import com.bit2.*;//패키지내 모든 클래스 가져옴
import static java.lang.Math.PI;//잘안씀 Math등 클래스명.하기 싫을때 가시성 떨어짐
/*
 * import: 외부 패키지가 어느 패키지에 있는지 명세함으로써 클래스 호출시 패키지명.을 생략하는 기능
 * 
 * import 패키지.클래스명: 우리 패키지꺼중에 있어도 import 패키지 클래스로 대체한다.(우선됨) 
 * import 패키지.*    : 우리 패키지꺼중에 없으면 import 패키지 클래스 사용한다.(우선안됨)
 * 
 * */
//import com.bit1.Ex01; 불허용
public class Ex02 {

	public static void main(String[] args) {
		Ex01 ex01=new Ex01();
		com.bit2.Ex01 ex11=new com.bit2.Ex01();
		Ex01 ex111=new Ex01();
		System.out.println(PI);
	}

}
