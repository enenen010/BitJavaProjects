package com.bit;

public class Ex11 {

	public static void main(String[] args) {
		int[] target=new int[] {1,3,5,7,9};
		int[] result;
		
		//for문 안써도 깊은복사 System에서 제공
		//배열이 워낙 사용성이 많다보니, 평소에 메모리관릴 하는 빠른 System 클래스에서 깊은복사 기능 제공
		
		//깊은 복사
		System.arraycopy(target, 0, result, 0,5);//시스템에요청 빠른 경향이 있음
		            //target어디부터읽어?  //result 쓰기시작 끝 
		for(int i=0;i<result.length; i++) {
			System.out.println(result[i]);
		}
		
		
		
		
		
		
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
