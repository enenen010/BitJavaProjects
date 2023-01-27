package com.bit;

import java.util.*;

public class Ex17 {
public static void main(String[] args) {
	String[] arr1= {
			"java"
			,"DB"
			,"web"
			,"framework"
	};
	
	//배열을 편하게 다루기 위해 제공되는 클래스 Arrays(jdk 1.2)
	//for 버려라
	System.out.println(Arrays.toString(arr1));
	
	//private 생성자 => 다 static
	
	String[] arr2=Arrays.copyOf(arr1, arr1.length);//깊은복사
	arr1[1]="database";
	System.out.println(Arrays.toString(arr1));
	System.out.println(Arrays.toString(arr2));
	
	//궅이 오버로드안해서 하나더 외워야함 자바실수
	String[] arr3=Arrays.copyOfRange(arr1, 1, arr1.length-1);
	System.out.println(Arrays.toString(arr3));
	
	int[] arr4= new int[3];
	Arrays.fill(arr4, 1234);//1234로 다채우기
	System.out.println(Arrays.toString(arr4));
	
	//들어가는게 객체면 이야기가 다름 compareTo
	int[] arr5= {1234,1234,1234};
	System.out.println(Arrays.equals(arr4, arr5));
	
	int[] lotto= {45,3,25,7,25,31};
	Arrays.sort(lotto);
	System.out.println(Arrays.toString(lotto));
	//binarySearch는 무조건 sort가 선행되어야 사용가능
	//이유: 크기비교인데 정렬까지안되있으면 너무하기힘듬 그럴거면 니가해라는 뜻
	//장:덕분에 수행속도는 매우빠름, 단:인덱스번호가 바뀜 sort해서
	System.out.println(Arrays.binarySearch(lotto, 26));//26몇번째?
	//없는번호 = 엉뚱한값 음수
	
	//배열을 리스트로
	List<Integer> list=Arrays.asList(45,3,25,7,25,31);
	//제네릭 있어야 된다네..
	for(int i=0; i<list.size();i++) {
		System.out.println(list.get(i));
	}
	
}
//귀찮: 매개변수 여러개
public static void func01(int a) {}
public static void func01(int a,int b) {}

//배열활용
//public static void func(int[] a) {}

//배열과 겹침: 오버로딩 못하게 되어있음
//가변인자
public static void func(int ... a) {//맨뒤로 받아야함 가변은
	//사용이 배열과 같음
	for(int i=0; i<a.length; i++) {}
	//사용 func03{"a",1,2,3,4} //1234 4개짜리 배열로 봐서 위에 안됨
 }
}
