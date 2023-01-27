package com.bit;

public class Quest03 {

	public static void main(String[] args) {
		/*
		 * 값 +2 {1,4,6,7,9}
		 * 
		 * 
		 * 0~10 홀수 담는 배열 출력
		 * 
		 * 알파벳 대문자 담는 배열
		 * 
		 * 오름차순 정렬 {9,10,20,7,2,4,8,3}
		 */
		 
		
		
		//값 +2 {1,4,6,7,9}
		int[] qArr1 = new int[]{1,4,6,7,9}; 
		for(int i=0;i<qArr1.length;i++) {
			qArr1[i]+=2;
		}
		System.out.print("[");
		for(int i=0;i<qArr1.length;i++) {
			 System.out.print(qArr1[i]+", ");
		}
		System.out.print("]");
		
		
		//0~10 홀수 담는 배열 출력
		int[] qArr2 = new int[5]; //n의 홀수= 2n-1 
		for(int i=0;i<qArr2.length;i++) {
			qArr2[i]=2*i-1;
		}
		System.out.print("[");
		for(int i=0;i<qArr1.length;i++) {
			 System.out.print(qArr1[i]+", ");
		}
		System.out.print("]");
		
		
		//알파벳 대문자 담는 배열
		char[] qArr3 = new char[26]; 
		for(int i=0;i<qArr3.length;i++) {
			qArr3[i]=(char)('A'+i);
		}
		System.out.print("[");
		for(int i=0;i<qArr3.length;i++) {
			 System.out.print(qArr3[i]+", ");
		}
		System.out.print("]");
		
		
		
		//오름차순 정렬 {9,10,20,7,2,4,8,3}
		int[] qArr4 = new int[]{9,10,20,7,2,4,8,3};
		

		for(int i=0;i<qArr4.length;i++) {
			for(int j=i+1;j<qArr4.length;j++) {//max와 교체
				if(qArr4[i]>=qArr4[j]) {
					int temp;
					temp=qArr4[i];
					qArr4[i]=qArr4[j];
					qArr4[j]=temp;
				}
			}
		}
		//-------------------------------------
		
		
		
		System.out.print("[");
		for(int i=0;i<qArr4.length;i++) {
			 System.out.print(qArr4[i]+", ");
		}
		System.out.print("]");
	}

}
