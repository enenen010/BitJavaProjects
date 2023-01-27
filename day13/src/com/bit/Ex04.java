package com.bit;

import java.util.ArrayList;
import java.util.LinkedList;

public class Ex04 {

	public static void main(String[] args) {
		java.util.ArrayList arr=new ArrayList();
//		java.util.LinkedList arr==new LinkedList();
		arr.add(1111);
		arr.add(true);
		arr.add(3333);
		arr.add(4444);
		
//		long before=System.currentTimeMillis(); 
//		for(int i=0; i<100000000; i++) {
//			arr.add(i);
//		}
//		long After=System.currentTimeMillis();
//		System.out.println(After-before); 6~7 조작은 별차이 없음
		
		long before=System.currentTimeMillis();
		for(int i=0; i<100000000; i++) {
			Object obj=arr.get(i);
		}
		long After=System.currentTimeMillis();
		System.out.println(After-before); //출력 차이 많이남 링크드 너무느림
		
		//특수한 상황이 아니면 다 ArrayList
	}
}
