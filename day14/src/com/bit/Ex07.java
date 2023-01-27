package com.bit;

import java.util.*;
public class Ex07 {
	
	
//===================================================	
	public static Box<?> func(int su){//실행할때 타입이 결정
		if(su>0)
			return new Box<String>();//웹에서 꽤 쓴다
		else
			return new Box<Integer>();
	}
//===================================================
	public static Box<? super Integer> func01(int su){//Integer 이상
		
		if(su>0)
			return new Box<Number>();
		else
			return new Box<Integer>();
	}
//===================================================
	public static Box<? extends Number> func02(int su){//Number 이하
		if(su>0)
			return new Box<Number>();
		else
			return new Box<Integer>();
	}
//===================================================
	
public static void main(String[] args) {
	
	
	//1.기본
	Box<String> box=new Box<String>();
	
	//2.제네릭 안쓴거랑 같음
	Box<String> box1=new Box();
	Box box2=new Box<String>();
	
	//3.기능적
	Box<String> box3=new Box<>();//jdk1.7부터 가능 생략 -> 웹으로가면 날수도 있음
	Box<?> box4=new Box<String>();//미루겠다 위에 자세히 설명
	((Box<Integer>)box4).setSu(1234);//<?> 예제 //사용할땐 결국 결정
	
	

	//2.제네릭 안쓴거랑 같음
//	Box<String> box1=new Box();
//	Box box2=new Box<String>();
	Object obj = box2.getSu();
	System.out.println(obj);
//	
//	box1.setSu("1234");
//	box1.setSu(1234);
//	box2.SetSu(1234);

	
	

	
}
}
