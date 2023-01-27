package com.bit;


interface M<T>{
	void exe();
}
class A {
	static int a=1;
	private void exe() {
		System.out.println("A");
	}
};

class B extends A {
	int a=2;
	void exe() {
		System.out.println("B");
	}
};

class C extends B implements M{
	public void exe() {
		System.out.println("C");
	}
	void exe2() {
		System.out.println("C2");
	}
};

public class Test02 {

	public static void main(String[] args) {
		
		// 동적 바인딩
		C var1 = new C();
		var1.exe();
		
		A var2 = null;
		var2 = var1;
		//var2.exe();
		System.out.println(var2.a);
		
		var1=(C)var2;
		
		int a=(int)1.4f;
		
		M var3=var1;
	}

}