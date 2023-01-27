package com.bit;

import com.bit2.Lec22;

class Lec02{
	protected int su1;
}

//생성자도 마찬가지 부모생성자가 접근불가면 여기 오류뜸 (생성자가 프로텍티드 다른패키지면)
public class Ex02 extends com.bit2.Lec22{

	public static void main(String[] args) {
		//public > protected >= default > private 
		Lec02 me =new Lec02();
		System.out.print(me.su1);
		com.bit2.Lec22 you;
		
		//상속을 해야 가능 (기본적으론 다른 패키지꺼 안됨) 
		//생성자도 마찬가지
		you=new com.bit2.Lec22(su1);
		you.func02();
		
	}

}
