package com.bit;
//있는거 재정의 하거나, 클래스 자체가 한번만 필요할거면
//굳이 이름까지 지어야 되나?
//이름 안짓도록-> 익명 클래스!!!!

//한번쓸거라 이름도 안짓고 관리도 안할 클래스 만들고 싶을때=> 귀찮아서
//관리? ArrayList.sort()는 Comprator객체를 상속받는데 이거는 모든 리스트마다 다 다른기능임
//이걸 하나하나 정렬 이름지어가며 만들고 Comprator상속시켜서 관리하는건 너무나 귀찮은일
//익명 클래스로 하면 해결된다!!

//화살표  list.sort((a,b)->a-b) 에로우 펑션 따라만듬   익명클래스가 아니라 익명 메서드

//나중에 버튼도 버튼마다 기능이 다다름 그 기능에 하나하나 이름붙여가며 상속시켜서 관리하는거 nono

interface Inter{
	void func();
}

//인터페이스만 익명클래스 사용때 쓰나?

//no 추상 클래스도
abstract class Lec05{
	int a=1;
	abstract void func02();
	java.util.ArrayList arr=new java.util.ArrayList();
}

//그냥 클래스도
class Lec55{
	void func02() {
		System.out.println("본래 기능");
	}
	
}

//결국 내가 필요한 기능만 오버라이딩 해서 사용할 때


class Outter05{
	static void func01(){
		//목적: 한번호출하고 말 클래스 앤간한건 생략하자
		
		class Loc{
			void func() {
				System.out.println("익명클래스 만들기");
			}
		}
		
		//부모클래스, 인터페이스 형식으로 자식 클래스를 받을수 있기에
		//클래스파일을 생성하지 않고 1개의 객체만 생성할거면 
		
		
		//1.요거를
		class aaa extends Lec55{//이름지어야 하잖아..
			void func() {}
		};
		Lec55 obj1=new aaa();
		
		//2.이런식으로 줄이고 (문법상에러임)
		//Lec55 obj1=new class aaa extends Lec55{};
		
		//3.완성                
		Lec55 obj=new Lec55() {
			public void func() {
				System.out.println("익명클래스로 재정의");
			}
		};
		//활용: 1.이미있는 클래스를 일부분만 바꾼 기능이 한번만 필요할때(기존클래스 상속시켜서)
		//     2.클래스의 기능자체가 1번만 필요할때   (적당한 인터페이스, 추상 만들고 사용)
		
		
		/*
		 * 1.static붙이면 1번처럼
		 * 2.안줕이면 2번처럼
		 * 3.메서드에 들어가면 로컬클래스 3번 처럼     다되는애
		 */
	}
}


public class Ex05 {
public static void main(String[] args) {
	Outter05 outt=new Outter05();
}
}
