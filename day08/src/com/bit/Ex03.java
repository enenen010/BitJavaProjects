package com.bit;

public class Ex03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String msg1="문자"+"열";
		String msg2="문자".concat("열");
		//레퍼런스 비교(참조변수에서만)
		System.out.println(msg1==msg2);
		System.out.println(msg1.equals(msg2));//switch와 같음
		
		//msg1.getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin)
				//원하는만큼만 잘라줄게    시작                끝                    대상                    출발점
		        //리턴없는이유    dst배열의 원하는 부분을 치환하는 거라서	
				//void가 있으면 들어간 객체가 바꿜 확률이 높음
		byte[] arr1=msg1.getBytes();
		char[] arr2=msg1.toCharArray();
		
		//true: 참조변수라면 다가지고 있음 =>모든 객체가 가지고 있음
		// 참조변수도 어떻게하든 출력해야하기 때문
		System.out.println(new Sting(arr3));//string의 형변환 미리안올라가있는거면 어차피 새로만들어서 써야함
		System.out.println(msg1==msg1.toString()); 
		
	}

}
