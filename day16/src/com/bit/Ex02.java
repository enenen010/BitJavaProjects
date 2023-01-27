package com.bit;

public class Ex02 extends Thread{//상속이더라도
	public void run() {
		System.out.println(Thread.currentThread().getName());
		System.out.println("새로운 쓰레드로 작업");
	}
public static void main(String[] args) {
	//java.lang.Thread thr=new Thread();
	System.out.println("main start");
	Ex02 thr=new Ex02();
	//thr.run();//main에서 실행되기에 run은 새로운 쓰레드가 아닌 main이 실행
	
	thr.start();//run()메서드를 새로운 쓰레드를 생성하여 실행하는 명령
	System.out.println("main end");
	
	/*
	 * main start
	   main end
       Thread-0
            새로운 쓰레드로 작업
       
       ->main이 끝났는데 작업이 진행? 지금까지는 main스레드 하나였기때문
       
       늦게나온건 main스레드 작업시간 주어진게 문자2개찍는걸로는 안끝나서
       더 여러개면 Thread-0갔다가 실행하고 다시와서 문자찍을거임
	 */
}
}
