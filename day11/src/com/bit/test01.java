package com.bit;

public class test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println((byte)(System.currentTimeMillis()));
		
		java.util.Scanner sc; 
		System.out.println("입력시작 전");
		sc= new java.util.Scanner(System.in);
		System.out.println("입력시작");
		for(int i=0;i<6;i++) {
			sc= new java.util.Scanner(System.in);
		}
		int a = sc.nextInt();
	}

}
