package com.bit;

//상속의 효과 :  근데 상속보다 특징적으로는 좋은점이 거의 없음
		/*
		 * 1.헷갈림 $가 그냥 넣을 수도 있음 그냥 암묵적인 룰
		 * 2.클래스 안에 클래스 직접 들어가야함
		 * 3.재사용성이 떨어짐
		 * 
		 * 
		 * 언제쓰는가?
		 * 1.두 클래스가 서로 긴밀한 관계에 있거나 하나의 클래스 메서드에서만 사용되는 클래스
		 * 
		 * 
		 * 
		 * 1.상속관계인 클래스들의 공통점을 클래스로 서술하고 싶을때(메서드, 필드 더 나아간 표현)
		 * 2.해외: 자체적인 시스템 내부에 사용하는
		 *   국내: 거기에서 주어지는 모듈들을 이용한 추가적인 개발이 가능한 확장성을 중요시
		 */

class Outter02{
	static int su1=1111;
	int su2=2222;
	
	
	static class Inner02{
		static int su3=3333;
		int su4=4444;
		
		Inner02(){}
		
		static void func03() {
			//func04와 같이 su1은 내가 가지고 있는 것처럼 사용가능(상속이랑 비슷한 효과)
			//만약 static int su1=3333;이 Inner02에 있다면 su1은 3333이 나옴
			System.out.println(su1); //Inner02.su1 생략
			func01();
			Outter02 outt=new Outter02();
			System.out.println(outt.su2);
			outt.func02();
 		}
		void func04() {
			System.out.println(su1); //Inner02.su1 생략
			func01();
			Outter02 outt=new Outter02();
			System.out.println(outt.su2);
			outt.func02();
		}
	}
	
	
	Outter02(){}
	
	static void func01() {
		System.out.println(Inner02.su3);
		Inner02.func03();
		Inner02 inn1=new Inner02();
		System.out.println(inn1.su4);
		inn1.func04();
	}
	void func02() {
		Inner02 inn1=new Inner02();
		System.out.println(Inner02.su3);
		Inner02.func03();
		System.out.println(inn1.su4);
		inn1.func04();
	}
}

public class Ex02 {
	
public static void main(String[] args) {
	//클래스 밖에서 접근
	System.out.println(Outter02.su1);
	Outter02.func01();
	Outter02 outt=new Outter02();
	System.out.println(outt.su2);
	outt.func02();
	////////////////////////////////
	//java.util.Map.Entry e; //내부클래스였음
	
	//안쪽 클래스 접근
	System.out.println(Outter02.Inner02.su3);//접근 안됨 Inner02.su3 으로는
	Outter02.Inner02.func03();
	Outter02.Inner02 inn=new Outter02.Inner02();
	System.out.println(inn.su4);
	inn.func04();
}
}
