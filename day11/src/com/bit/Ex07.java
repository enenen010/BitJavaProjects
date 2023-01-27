package com.bit;

public class Ex07 {
	
	void func2() {
		System.out.print("");
	}

	public static void main(String[] args) throws ClassNotFoundException {
		Object obj=new Object();
		
		//클래스 형식 받아내는 2가지 방법 //클래스에대한 정보를 받아내는 클래스
		Class cls1=obj.getClass();
		Class cls2=Object.class;
		
		//실습1. 객체찍기 1
		Ex07 me=new Ex07();
		Class cls3=me.getClass();
		Class cls4=Ex07.class;
		
		//실습2. 객체찍기 2  =>아직 안만든 클래스를 생성할 것이라고 할 수도 있다!
		//                 데이터 드라이빙 할때 가장 많이씀 =>이름만 넣으면 드라이브 추가!!!
		Class cls5=Class.forName("com.bit.Ex07");//throws   or   try catch 처리

		Object obj2=(Ex07)cls5.newInstance();
		System.out.println();
		obj2.func2(); //new에비해서 성능은 떨어지지만 확장적인 측면이 좋음
	}

}
