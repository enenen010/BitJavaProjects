package com.bit;

public class Ex09 extends Thread {
	public void run() {
		System.out.println("new start");
		try {
			sleep(1000);//내꺼니까 그냥씀
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("new end");

	}
public static void main(String[] args) {
	Ex09 me=new Ex09();
	me.start();
	System.out.println("main start");
	try {
		Thread.sleep(1000);//1000이 1초, 1초이상 잠듬(1초는보장)
		    //sleep(1000,000)1000의1초 부족하면 나노세컨추가
	} catch (InterruptedException e) {//안깨어나면 오류
		e.printStackTrace();
	} 
	System.out.println("main end");
}
}
