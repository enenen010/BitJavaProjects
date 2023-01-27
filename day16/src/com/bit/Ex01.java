package com.bit;

public class Ex01 {
	public void func2() {
		System.out.println(Thread.currentThread().getName());
	}
public static void main(String[] args) {
	//스레드를 안쓴게 아니라 딱 1개만 쓰고 있었던 거다
	System.out.println("main start");
	Ex01 ex01=new Ex01();
	ex01.func2(); //그이름은 main
	System.out.println("main start");
	
	//지금까지 1개 수행될동안 다른거 못했음 스레드 1개여서
}
}
