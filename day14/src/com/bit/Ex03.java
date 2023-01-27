package com.bit;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class Ex03 {
	public static void main(String[] args) {
		//제네릭 안써도 됨 되도록이면 써달라 장점이 있다
		//문법을 제약하는 것임, 너무 자유롭기 때문에
		//캐스팅 실수로 인한 오류가 많음
		//컬렉션 프레임 워크 할 때는 제네릭 사용 필
		//안쓴것과 동일하게 <Object>더라도 가시성을 위해 사용
		
		//List arr=new ArrayList();//너무 자유로움
		List<String> arr=new ArrayList<String>();
		arr.add("문자열1");
		//arr.add(111); 제네릭을 해야 잡을 수 있는 자유로움(오류)
		arr.add("문자열2");
		arr.add("문자열3");
		
//		for(int i=0;i<arr.size();i++) {//캐스팅 필요없음
//			Object abj=arr.get(i);
//			System.out.println((String)abj+"입니다");
//		}
		
		//의의:  제약 -> 사용자가 스스로 뭘 담을지 결정가능(원랜 개발한 애가 결정)
		//사용 시점에 자료형 결정 가능
		for(int i=0;i<arr.size();i++) {
			String abj=arr.get(i);
			System.out.println(abj+"입니다");
		}
		
		//컬렉션 프레임워크에서 제일 많이 씀
		//참조변수의 타입만 가능->
		Map<String, Integer> map=new HashMap<String, Integer>();
		//나중에 put으로 값넣을때 int로 해도 박싱됨
		
	}
}
