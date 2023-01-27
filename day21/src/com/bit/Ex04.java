package com.bit;

class Lec04 extends Thread{
	boolean boo;
	public Lec04() {
		
	}
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			if(boo) yield();
			System.out.println(getName()+"working.."+i);
		}
	}
}

public class Ex04{ 

	public static void main(String[] args) {
		Lec04 ex1=new Lec04();
		Lec04 ex2=new Lec04();
		ex1.start();
		ex2.start();
		for (int i = 0; i < 10; i++) {
			ex1.yield();//양보 즉시 runable로
		}
	}
}
