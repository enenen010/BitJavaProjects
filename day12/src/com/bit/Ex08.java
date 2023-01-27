package com.bit;

public class Ex08 {

	public static void main(String[] args) {
		char ch1='a';
		Character ch2=new Character('A');
		Character ch3=new Character((char)65);
		
		//필드뭐하는 거냐? 대부분 상수값임, 우리가쓰는게 아니라 내부메서드가 자동으로 뭐하려고 있는거임
		//MAX_VALUE, MIN_VALUE 등 각자 
		
		//둘다 문자인지 반환하는 거 (알파벳만 아님 '가'도 된다)
		System.out.println(Character.isLetter(ch1));
		System.out.println(Character.isAlphabetic(ch1));//가급적이거써달라함
		
		System.out.println(Character.isDigit(ch1));//숫자냐?
		
		//특수문자는?
		//문자는   1.문자, 2.숫자, 3.특수문자임    1,2가 아니면 특수문자이므로 따로 찾는 기능은 없음
		System.out.println(Character.isSpace(ch1));
		//빗금 의미 곧 없어질것이다.(메이저버전업때) 
		//-> java는 안함 써도됨 ->안쓰는것들은 조용히 없애는분위기 (하위호환 위해)
		System.out.println(Character.isWhitespace(ch1));//이거 권장 공백은 특수문자중 좀 특별
		
		//대문자소문자찾기 둘다아니면 일단 영어는 아니다
		System.out.println(Character.isUpperCase(ch1));
		System.out.println(Character.isLowerCase(ch1));
	}
}
