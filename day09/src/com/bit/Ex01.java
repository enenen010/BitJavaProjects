package com.bit;


public class Ex01 {

	public static void main(String[] args) {
		// continue; return; break;
		
		//return;		값을 리턴하고 '메서드를 종료'	메서드 어디에나 존재		메서드를나감
		// continue;	이번 반복을 멈추고 다음반복시작	반복문				안나감-다음회차
		// break;		{}구문을 빠져 나감 '해당 구문'	반복문, switch 나감	반복문,switch을 나감
		
		
	}
	public static void func01() {
		
		for(int i=0; i<10; i++) {
			System.out.println("i=="+i);
			
			
		}
		return;
		
	}
	
}
