package com.bit;

public class Ex09 {

	public static void main(String[] args) {
		double su1=3.14;
		Double su2=new Double(3.14);
		Double su3=new Double("3.14");
		
		System.out.println(su2.intValue());//소수점안녕
		System.out.println(Double.parseDouble("3.14"));//형변환
		System.out.println(Double.toHexString(3.14));
		
		//분모분자가 있으면 분자가커지면 커지고 분모가 커지면 작아짐
		//여러가지 문제 생김 무한대 무한소 ---> 회피하자
		
		double su4=1.0;
		double su5=0.0;
		System.out.println(su4/su5);//Infinity 나옴
		System.out.println(Double.isInfinite(su4/su5));//true 무한이라는뜻
		su4=0.0;
		System.out.println(Double.isNaN(su4/su5));//true 모른다는뜻
		
		
		//float su6=3.14;
		Float su7=new Float(3.14);
	}
}
