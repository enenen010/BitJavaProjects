package com.bit;

public class Ex06 extends Thread{
	public void run() {
		Thread thr=this;
		System.out.println(thr.getName());
	}
	
	public static void func() {
//		Thread thr=this;//이건 static이라서도 this 안됨
		Thread thr=Thread.currentThread();//최근쓰레드리턴=자신
		System.out.println(thr.getName());
	}
public static void main(String[] args) {
	Ex07 me=new Ex07();
	//me.start();
	
	Thread thr=new Thread(me);
}
}
