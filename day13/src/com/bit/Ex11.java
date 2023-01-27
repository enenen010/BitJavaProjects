package com.bit;

public class Ex11 {
public static void main(String[] args) {
	java.util.Set set1;
	set1=new java.util.HashSet();//제일 문제 없는 set
	                             //매번 같은 위치에 무작위 실행

	
	//순서가 없다? 인덱스가 없다!!
	//어떻게 끄집어냄? 벡터의 이너머레이션
	set1.add("첫번쨰");
	set1.add("두번쨰");
	set1.add("세번쨰");
	set1.add("네번쨰");
	set1.add("다섯번쨰");
	//벡터를 위한 이너머레이션 set을 위한?
	
	java.util.Iterator ite;
	ite=set1.iterator();
	while(ite.hasNext()) {
		System.out.println(ite.next());
	}
	
	/* 순서가 없는 자료구조? -> 얘가 표현하고 싶은 것: "집합"
	 * (순서가없을수가 없다 랜덤을 생각해봐라)
	 *               :어떻게보면 억지로 만듬 이론상 말이 안됨
	 *               
	 * 순서가 없는 자료구로로써의 "집합"의 특징
	 * 1. 중복이 없다: 같은 값 두개를 구분하는 법=순서, 순서가 없다? 중복도X
	 * 2. 순서O: 중복인지 아닌지 찾을려면 순서가 있어야함
	 * 
	 * 
	 * 순서가 없을려면? 중복이 없어야 한다, 중복을 검사하려면? 순서가 있어야한다.
	 * 결국, 이론과 실체가 다름? 중복을 없앤 선형 -> 비선형인척하는 선형
	 */
	
	
	//1.중복을 없애는법
	System.out.println(set1.add("첫번쨰"));//true  들어감
	System.out.println(set1.add("첫번쨰"));//false 안들어감
	System.out.println(set1.add("첫번쨰"));//false 중복검사
	
	//2.순서 없는것처럼 보이게
	set1.clear();
	set1.add(1111);
	set1.add(2222);
	set1.add(3333);
	set1.add(4444);
	set1.add("첫번째");
	
	System.out.println(set1.remove(new String("첫번째")));//값비교임
	while(ite.hasNext()) {
		System.out.println(ite.next());
	}
	
	Object[] arr=set1.toArray();//출력하면 똫같음 위랑
}
}
