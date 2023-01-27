package com.bit;

public class Ex08 {
	
	public  static void func(Object su) {}
	public static void main(String[] args) {
		//래퍼 클래스
		func(123);//자동형변환
		
		//int->object 어째서? 기본자료형은 문자표등으로 정해졌지만
		//참조변수는 아니다
		
		
		//같은거임 
		func(123);
		func(new Integer(123));
		
		Integer val1 = 22;
		Integer val2 = 26;
		System.out.println(val1+val2);
		
		//참조변수와 기본형 변수의 연결점 => 래퍼 클래스
		//Object obj1=22; //에러 레퍼클래스는 연산이 가능 그러나 그러라고 만든거 아님
		//Object obj2=26;
		//System.out.println(obj1+obj2);
		
		
		int su1=1111;
		Integer su2=new Integer(2222);
		Integer su3=3333;
		
		//문자열 숫자로
		Integer su4=new Integer("4444");
		System.out.println(Integer.parseInt("1234"));//사용성 높음 얜int찍어주는데 위엔 객체
		
		//숫자 문자로
		System.out.println(Integer.toString(1234));
		
		System.out.println(su3==su4); //false
		System.out.println(su3.equals(su4));
		System.out.println(su3.intValue()==su4.intValue()); 
		
		
		System.out.println(su4.getClass());
		System.out.println(Integer.BYTES);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.SIZE);
		
		System.out.println(Integer.reverse(2));
		
		int su9=1;
		System.out.println(Integer.toBinaryString(su9));//2
		System.out.println(Integer.toOctalString(su9));//8
		System.out.println(Integer.toHexString(su9));//16
		
		
		System.out.println(Integer.compare(33333, 0));//크면1 작으면-1 같으면0
		su2.compareTo(3333);
		
		//System.out.println(Integer.getInteger);
		//최종적으로 참조변수만드는데 어떻게 만들어내느냐가 다른거임
		
		byte su11=1;
		Byte su10=new Byte(su11);//생성자가 Byte로 받아서
	}

}
