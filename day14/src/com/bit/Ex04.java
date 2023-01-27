package com.bit;


interface Ball{
	void play();
}

class BaseBall implements Ball{
	String msg;
	BaseBall(){
		msg="거친 실밥이 박혀있는 ";
	}
	public void play() {
		System.out.println(msg+"공을 던지고 놉니다");
	}
}

class Lotto implements Ball{
	String msg;
	
	Lotto(int su){
		msg=su+"번";
	}
	
	public void play() {
		System.out.println(msg+"입니다");
	}
}

//class Box{    //인터페이스 활용 하였지만 여전히 둘의 공통점인 Ball카테고리에선 못벗어남
//	Ball su;    //그리고 Ball
//	
//	void setSu(Ball su) {
//		this.su=su;
//	}
//	Ball getSu() {
//		return su;
//	}
//}

class Box<Item>{	//기본적으로 Object인 자리를 대체하는 개념이라 참조형만 가능
					//여기에 물건이 들어갑니다. 어떤물건인지는 니가 결정하세요
	Item su;        //수십 수천개의 클래스를 제네릭 하나로 해결가능
	                //이 클래스 하나를 위해 인터페이스를 만들기도 싫음
	                //딱 자기가 원하는 개념을 정의할 수 있음
					//사용하는 키워드 명명규칙 => 일반적으로 T(타입),E(자료구조요소),K(키),V(값) 등
	void setSu(Item su) {
		this.su=su;
	}
	Item getSu() {
		return su;
	}
}

public class Ex04 {
public static void main(String[] args) {
	Lotto ball1=new Lotto(0);
	Box<Lotto> box=new Box<Lotto>();
	box.setSu(ball1);
	
	Ball su=box.getSu();//play() 없다
//	((Lotto)su).play(); //이 한계를 극복하려면?
}
}
