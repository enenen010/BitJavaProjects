package com.bit;

import java.io.IOException;
import java.nio.CharBuffer;

public class Ex12 {
public static void main(String[] args) {
	
//	1.우선순위 방식
//	:
	
//	쓰레드 90년대 정의된 개념-> 요새 벗어날려고 하는 방식=> 
//	이벤트 드라이빙 :  (node.js)등 하나는 감시 하나는 일, 마치이벤트호출하듯이
	
	Thread thr=new Thread() {
		@Override
		public void run() {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("end Thread");
		}
	};
	
	thr.start();
//	thr.start(); 이미 일하고있다 임마 오류
	
//	setPriority 1~10
//	default 5
//	max 10
//	min 1
//	상대적 빈도수임 
	
	Thread me=Thread.currentThread();
	System.out.println("main Thread:"+me.getPriority());
	Runnable thr0=new Runnable() {//thread객체가 아닌 객체가 할 일임
		@Override
		public void run() {//여러번 안적어되 된다 만세
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("end Thread");
		}
	};
	
	//쓰레드 실행중간 우선순위를 바꾸는건 말이 안됨
	Thread thr1=new Thread(thr0);
	Thread thr2=new Thread(thr0);	
	thr1.setPriority(Thread.MAX_PRIORITY);//10
	thr2.setPriority(Thread.MIN_PRIORITY);//1
	thr1.start();
	thr2.start();
	
	
}
}
