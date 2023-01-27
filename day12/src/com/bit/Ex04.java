package com.bit;

public class Ex04 {

	public static void main(String[] args) {
		int[] arr= {1,2,3};
		
		try {
			for(int i=0; i<4; i++) {
				System.out.println(arr[i]);
			}
		}catch(java.lang.ArrayIndexOutOfBoundsException e) {
			System.out.println("배열 오류");
		}
	}
}
