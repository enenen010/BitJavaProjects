package com.bit;

public class Ex11 {

	public static void main(String[] args) {
//		StringBuilder로 같다 붙여도 똫같이 
		StringBuffer st1=new StringBuffer("java");
		st1.append(1111);
		st1.insert(4, "web");
		st1.insert(0, 2222);
		st1.replace(4, 8, "JAVA");
		st1.delete(4, 8);
		System.out.println(st1);
		st1.reverse();
		System.out.println(st1);
		
//		깊은 복사로 진행하고 싶을때
		StringBuffer st2=new StringBuffer(st1);
//		해서 딴걸하든 뭘하든
	}
}
