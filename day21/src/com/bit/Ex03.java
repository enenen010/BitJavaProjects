package com.bit;

public class Ex03 extends Thread{
	//1.슬립
	//2.웨잇
	@Override
		public void run() {
		while(true) {
			System.out.println(getName()+" working..");
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}
		}
public static void main(String[] args) {
	Ex03 me=new Ex03();
	Ex03 you=new Ex03();
	me.start();
	you.start();
	
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	you.interrupt();
}
}
