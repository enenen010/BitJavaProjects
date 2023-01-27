package com.bit;


//가장 좋은 방법은 쓰레드가 끝까지 실행되도록 애초에 코드를 짜는 것
//쓰레드가 대기상태에 들어가면 기다리는 애가 생겨 성능저하 생길 수 밖에 없음

//시작          : start
//종료	   : stop    Io에 치명적 파일날아감 close되기전 닫힘
//양보          : yield   - 활용 while(if else{yield})이면 안쓰는 반복때 양보
//대기상태로  : sleep, wait,join, suspend..         ↑안쓰는법 Good!
//대기상태 복귀: 시간(3000), 인터럽트(InterruptedException), resume 등등

class Lec06 extends Thread{
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			synchronized (this) {
				System.out.println(i+1+"번 수행....");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(i>1)notify();//1수행때 깨움 대기상태, 몇번째 running일진모름
				if(i>1)notifyAll();//다일어나
			}
		}
	}
}
public class Ex06 {
public static void main(String[] args) {
	System.out.println("main start");
	Lec06 lec=new Lec06();
	lec.start();
	//객체가 하나니 this
	synchronized (lec) {//wait할때 이거 안하면 이객체를 다른데서 쓸수 있으므로 막자 
		try {
			lec.wait(0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	System.out.println("main end");
	
	
//	Ex06 me=new Ex06();
//	//모든 객체에는
////	me.wait();//기다려
////	me.notify();//일어나 가 있다
//	
//	try {
//		me.wait();
//		me.notify();
//	} catch (InterruptedException e) {
//		e.printStackTrace();
//	}
}
}
