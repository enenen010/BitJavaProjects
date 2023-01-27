package com.bit;

class Lec08 extends Thread{
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
				System.out.println(getName()+" work...");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class Ex08 {
public static void main(String[] args) {
	System.out.println("main start");
	Lec08 lec=new Lec08();
	lec.setDaemon(true);//이제 main죽을때 같이 죽음
	lec.start();
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	System.out.println("main end");
	
}
}
