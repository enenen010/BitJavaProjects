package com.bit;

public class Ex04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String st1="abcdefg";
		
		//거꾸로
		st1.charAt(st1.length()-1);//인덱스로 문자찾음
		st1.indexOf("a");//제일 앞의 인덱스찾아줌  없으면 -1 양수는 인덱스로 착각
		//	indexOf(int ch, int fromIndex)
		//  indexOf(String str)
		//  indexOf(String str, int fromIndex)
		st1.lastIndexOf("g");
		
		st1.isEmpty();//비었니? => "".length()==0; 같은거임

		//문자열검사
		st1.contains("abc");//있니?
		st1.startsWith("a");//시작있니?
		st1.endsWith("g");//끝있니?
		
		String st2=st1.substring(3);
		st2=st1.substring(4,6); //01234 -> 123456 식으로 앞에하나 빠
		System.out.println(st2);
		
		String st5=st1.replace('a', 'A');//모든 a A로 바꿈
		 st5=st1.replace("ca", "cA");
		//format, replaceAll 표현식 사용 나중에 배움
		
		 
		//이 메서드를 실행해도 st1은 안바뀜 => String의 특성 
		
	}

}
