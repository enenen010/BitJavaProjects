package com.bit;


//2.클래스 -> 상속거부
final class Lac03{
	
	//4.필드 -> 변경불가
	final static int su2=222;
	final int su3=333;
	
	                     // 3.매개변수 -> 상수
	public static void func01(final int su) {}
	
	//final 사용처
	//1.메서드  -> 오바라이드 금지
	public final void func02() {}
}


public class Ex03 {

	public static void main(String[] args) {
		// 
		final int si1=1111;
		Lac03.func01(1);
	}

}
