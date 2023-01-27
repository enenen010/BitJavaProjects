package com.bit;

public class Ex05 {

	public static void main(String[] args) {
		// 주의: 에러에 맞는 익셉션을 사용해야 오류를 회피
		// 오류코드를 활용하자 출력창에 다 알려준다 어떤 오륜지 복붙
		System.out.println("시작");
		try {
			int su1=4;
			int su2=0;
			int su3=su1/su2;//오류발생된 순간 캐치로 넘어가서 아래구문은 실행안됨
			
		}catch(java.lang.AbstractMethodError e) {
			System.out.println("에러잡음");
		}
		//System.out.println(su1); 오류임 try{}안에 있는거 지역변수 취급
		System.out.println("종료");
	}

}
