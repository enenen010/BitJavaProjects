package com.bit;

public class Ex08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String msg1="한글";
		char[] arr1=msg1.toCharArray();
		for(int i=0; i<arr1.length; i++) {
			System.out.println(arr1[i]);
		}
		char[] arr2=new char[4];
		arr2[0]='한';
		arr2[1]='글';
		arr2[2]='자';
		arr2[3]='씩';
		String msg2=new String(arr2);
		System.out.println(msg2);
	}
	//앞으로 여러가지 문자지원을 볼텐데 다 이 2가지 바이트, 문자 배열 활용하여 만든거임   문자열 제어의 가장 베이스 => 나머진 이거 응용
}
