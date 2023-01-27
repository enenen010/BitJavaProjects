package com.bit;



public class Ex07 implements Runnable{
	
	public void run() {
//		Thread thr=this;//인터페이스라 this없음 객체를 못가져서
		//지금 호출되고 있는 자기가 제일 최근 쓰레드 아니냐
		Thread thr=Thread.currentThread();//최근쓰레드리턴=자신
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
	//System.out.println(me.getName()); Thread상속이 아니라 getName()메서드 없음
	
	Thread thr=new Thread(me);
}
}
