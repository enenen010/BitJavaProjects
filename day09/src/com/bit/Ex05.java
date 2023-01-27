package com.bit;

class Lec05{
	public void func01() {
		int su1=1;
		System.out.println("부모 기능");
	}
}

public class Ex05 {
	int su1=2222;
	public void func01() {
		System.out.println("자식 기능");
	}
	
	public void func02() {
		System.out.println("다른 기능2");
	}

	public static void main(String[] args) {
		Lec05 me1=new Lec05();
		me1.func01();
		Ex05 me2=new Ex05();
		me2.func01();
		me2.func02();
		Lec05 me3=new Lec05();
		me3.func01();
//		me3.func02();
//		((Ex05)me3).func02(); //억지로한다면
		
//		Lec05 me4=new Ex05(); //
	}

}
