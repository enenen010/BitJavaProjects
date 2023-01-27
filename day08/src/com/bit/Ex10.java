package com.bit;

public class Ex10 {

	public static void main(String[] args) {
		int[] arr1=new int[] {1,3,5,7};
		
		//배열복사(주소) => 얕은복사       //언제씀? 메소드 매개변수로 전달       ↓요런거
		int[] arr2=arr1;  //msg1.getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin)
		arr1[1]=2;
		
		//배열복사(힙공간복사) => 깊은복사
		for(int i=0;i<arr2.length; i++) {
			
		}
		
		int[] arr3=new int[] {1,3,5,7};//이거 모르니까
		arr3=new int[4];
		for(int i=0;i<arr1.length; i++) {//깊은복사
			arr3[i]=arr1[i];
		}
	}
	//얕은복사
	public static void func1(int[] arr){ //static이유 main에서 접근하려면 객체생성해야되서 귀찮
		//arr=arr1;
		arr[0]=0;
	}

}
