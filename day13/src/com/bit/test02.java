package com.bit;
class AAA{
	int ab=1;
	public void func01() {
		ab=2;
	}
}
class BBB extends AAA{
	int b=1;
	public void func01() {
		ab=3;
	}
	public void func02() {
		ab=4;
	}
}


public class test02 {
public static void main(String[] args) {
	AAA a=new AAA();
	a.func01();
	System.out.println(a.ab);
	
//	BBB b=(BBB)a;
//	System.out.println(b.ab);
	
	AAA a2=new BBB();
	BBB b2=((BBB)a2);
	b2.func01();
	System.out.println(b2.ab);
	
}
}
