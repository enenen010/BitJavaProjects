package com.bit;

class AAA {
	static int m1 = 1;

	void func01() {
		System.out.println("AAA를 실행");
	}
	void func02() {
		m1+=1111;
	}
}

class BBB extends AAA {
	int m1 = 2;

	void func01() {
		System.out.println("BBB를 실행");
	}
	void func02() {
		m1+=2222;
	}
}

public class test02 {
	public static void main(String[] args) {
		AAA a = new BBB();
		BBB b = (BBB) a;

		System.out.println(a.m1=a.m1+10000);
		System.out.println(b.m1);
		//a.func01();
		//b.func01();
		a.func02();
		b.func02();
		System.out.println(a.m1);
		System.out.println(b.m1);
		

	}
}
