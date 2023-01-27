package com.bit;

public class Ex01 {

	public static void main(String[] args) {
		// String str = new String(); 쓰지말자 String의 장점이 사용
		//객체는 더도말고 덜도말고 꼭필요한만큼만 쓰는게 제일 좋음 (그래서 싱글톤 차선책)
		
		/*
		 * String(byte[] bytes, int offset, int length, Charset charset)
			Constructs a new String by decoding the specified 
			subarray of bytes using the 
			specified charset.
		 * 
		 */
		
		//Stirng str = " "; Stirng객체들이 같을유일한경우 + ""+""까지
		String msg1="문자열";
		String msg2="문자";
		String msg3="열";
		String msg4=msg4=msg2+msg3;
		String msg5="문자"+"열";
		
		System.out.println(msg1==msg2+msg3);
		System.out.println(msg5==msg4);
		System.out.println(msg1==msg5);
		
		//========================
		String msg6="문자".concat("열"); //역할 더하기 : 
		 //문자들을 분해했다가 다시조합하는 과정에서 new로 새로운 객체를 반환. String에서 메서드를 쓰면 무조건
		 
		
		
		
		//====================================
		char[] arr = new char[]{'a','b','c','d'};
		System.out.println(new String(arr,0,3));
		String st3=new String("문자열");
		System.out.println(st2);
	}

}
