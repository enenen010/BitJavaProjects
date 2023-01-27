package com.bit;

import com.bit.Outter02.Inner02;

class Outter03{
	static int su1=1111;
	int su2=2222;
	
	
	class Inner03{//객체가 찍혀야 존재 가능한 클래스
//		static int su3=3333; //   안됨    class가 non-static(객체있어야있는데)인데 static가지지마
		final static int su3=3333;   //예외: 상수영역할당이라 가능  
		int su4=4444;	
		Inner03(){}
//		static void func03() {} 안됨
//		final static void func03() {} 안됨: 상수가 아니라 그냥 오버라이딩이 안되는 거임
		
		void func04() {//객체가 찍혔다는 가정하이므로 그냥 다 접근
			System.out.println(su1);
			System.out.println(su2);
			func01();
			func02();
		}
	}
	
	
	Outter03(){}
	
	static void func01() {
//		System.out.println(Inner03.su3);
//		Outter03 outt=new Outter03();
//		Inner03 inn=outt.new Inner03();
//		System.out.println(inn.su4);
//		inn.func04();
	}
	void func02() {
		Inner02 inn1=new Inner02();
		System.out.println(Inner02.su3);
		Inner02.func03();
		System.out.println(inn1.su4);
		inn1.func04();
	}
}
public class Ex03 {
public static void main(String[] args) {
	////Outter03 그냥 클래스 접근하듯이
	
	//Inner03
	System.out.println(Outter03.Inner03.su3);
	Outter03 outt=new Outter03();
	Outter03.Inner03 inn;
	inn=outt.new Inner03();
	
	
	System.out.println(inn.su4);
	inn.func04();
	
}
}
