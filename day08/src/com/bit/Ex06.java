package com.bit;

public class Ex06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String target="";
		
		//사용자 중심의 프로그래밍 => 사용자가 보기 쉽게 띄어쓰기는 알아서 처리등
		//일반인들은 몰라서 못하는 부분들을 예외처리
		//System.out.println(target.trim());//양끝 공백제거
		
		
		//데이터베이스를 써야지 할수있는거아님
		//텍스트파일로 저장해 직접관리하면됨 귀찮으면? => 데이터베이스
		target="강원도|환천군|상북면";
		String[] arr1 = target.split("\\|");
		
		target="java  dk sldlfsk";
		arr1 = target.split(" "); //3개가 아니라 4개 나옴 1개 빈배열 주의하자
		
		String st1="가";
		String st2="나";
		System.out.println(st1.compareTo(st2));//같은지다른지, 글자가얼마나차이나는지, 길이가//
		//결과1.문자는 같은데 길이만 차이나면 =부분집합이면  길이차이 뒤어껄로 뺌 값 반환
		//결과2.문자가 다른 부분이 있음 => 그 위치의 문자코드값 뒤에껄로 빼서 반환  - 길이차이반환x
		//결과3.같으면 0반환
		
		
	}

}
