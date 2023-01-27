package com.bit;

public class Ex05 {
	public static void main(String[] args) {
		long before=System.currentTimeMillis();
		String msg="";
		for(int i=0;i<10000;i++) {
			msg+=i;
		}
		long after=System.currentTimeMillis();
		System.out.println(after-before);//문자열10000개찍는데 걸린시간
		
		//currentTimeMillis 유통기한 얼마 안남음 다 따라잡음 밀레니엄 버그
		System.out.println(Long.MAX_VALUE);
	}
}
