package com.bit;

public class Ex08 extends Thread{
	
	public Ex08() {
		//super("뉴스레드");//이름설정1
		//thr.setName("새 쓰레드");//이름설정2
	}
	
	public void run() {
		Thread thr=Thread.currentThread();
		//thr.setName("새 쓰레드");//이름설정2
		System.out.println("this="+this.getName());//객체명
		System.out.println("curr="+thr.getName());//쓰레드명
		
		//기본적으로 ID 씀 name는 바뀔수 있어서
		System.out.println("this="+this.getId());
		System.out.println("curr="+thr.getId());
		
		//보기편한게 이름, 제어할때 ID
	}
public static void main(String[] args) {
	Ex08 me=new Ex08();//기본적으로 쓰레드를 상속받고 객체생성시마다 새로운 이름,ID를 할당(쓰레드할당아님)
	Ex08 me2=new Ex08();//객체를 생성할 때마다 
	me.run();  // 
	System.out.println("=================");
	me2.run();  //실행큐엔 안들어감 
	System.out.println("=================");
	me.start(); //들어감
}
}
