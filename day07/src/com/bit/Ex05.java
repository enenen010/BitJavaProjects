package com.bit;

public class Ex05 {

	public static void main(String[] args) {
		//문자들의 집합
		System.out.println(""); //이것도 됨
		
		String st1;
		st1="문자열"; //=0x0011
		st1=null; //집합객체가 없음      디폴트값 
		st1="";   //집합객체 있음, 문자가 없음 
		String st2=new String("문자열");//0x0011
		String st3="문자열";//=0x0011
		
		System.out.println(st1==st2); //false:
		System.out.println(st1==st3); //true: 0x0011==0x0011
		System.out.println(st2);//새로운주소의 "문자열"  출력=>문자열
		
		java.util.Scanner sc;
		sc=new java.util.Scanner(System.in);
		//String st4=sc.nextLine();
		//프로그래밍은 숫자 or 문자열을 제어하는 것이다. => 더 많아짐 근래 문자열 문자아님
		//System.out.println(st1==st4);//false: 
		String st010 = "문자"+"열";
		System.out.println(st1==st010); 
		String st111 = "가나다라마바사아자차카파타하ㅏㄹㄴ어닐언이ㅏ러니어린어리ㅏㄴ어리ㅏ너ㅣ런이ㅏㄹ넝리ㅏㅓㄴㅇ리ㅏㅓㄴ아ㅣ러미ㅏㄴㅇ럼;ㅣㄴ얼ㅇㄴㅁ";
		String st112 = "가나다라마바사아자차카파타하ㅏㄹㄴ어닐언이ㅏ러니어린어리ㅏㄴ어리ㅏ너ㅣ런이ㅏㄹ넝리ㅏㅓㄴㅇ리ㅏㅓㄴ아ㅣ러미ㅏㄴㅇ럼;ㅣㄴ얼ㅇㄴㅁ";
		System.out.println(st111==st112);
		
	}

}
