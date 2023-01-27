package com.bit;

public class Ex07 {

	public static void main(String[] args) {
		// String의 다른 해석 방법 바이트의집합(크기), 문자들의 집합        바이트체게이므로
		String msg1="가나";
		byte[] arr1=msg1.getBytes(); //바이트 배열 1칸이 1바이트임 즉 length가 곹 크기
		System.out.println(arr1.length); //6바이트 => utf8은 3바이트 문자체계다=> 
		                                 //영어는왜1바이트? 가변형자료형 경우의수 : 그범위로 해결나는 문자면 그 바이트사용 아스키코드에붙임 
		                                 //뭐는 유니코드를 엔코딩한거
		//문자는 문자만가지고 해석안함 문자코드와 ....  -> 숙제: 문자코드와 엔코딩에대해서 알아보기
		
		for(int i=0; i<arr1.length; i++) {
			System.out.println(arr1[i]);
		}
		byte[] arr2=new byte[4];
		arr2[0]=-128;
		arr2[1]=-21;
		arr2[2]=-126;
		arr2[3]=-104;
		String msg2 = new String(arr2);
		System.out.println(msg2);  //뒤에가서 IO할때 이거임 바이트스트림 1바이트 스트림: 영어가1바이트라면 한글자는 3바이트 넘어가면 글자깨짐: 자료형이 다르다고 보면됨
	}

}
