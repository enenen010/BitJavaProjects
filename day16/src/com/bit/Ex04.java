package com.bit;

public class Ex04 {
public static void main(String[] args) {
	//쓰레드를 객체생성하면서 할일을 넣어준다음
	//이전꺼는 객체가 main할일도 가지고 있어서 이상
	//클래스를 새로 만들어 넣자 -> 익명 클래스!!
	
	Thread thr=new Thread(new Runnable() {
		public void run() {
			Thread thr=Thread.currentThread();
			String name=thr.getName();
			System.out.println(name+" start...");
			System.out.println(name+" end...");
		}
	});//쓰레드 생성법 할일=run()을 가진 객체를 넣어줌
	thr.start();
}
}
