package com.bit;

public class Ex02 extends Thread{
	@Override
		public void run() {
			System.out.println(getName()+" start..");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(getName()+"end..");
		}
public static void main(String[] args) {
//	start()하면 runable상태 된다 거기서 선택밭은 쓰레드만 running상태된다
	System.out.println("main start..");
	Ex02 me=new Ex02();
	me.start();
	try {
		me.join(3000);//쓰레드끝날때까지 기다림(몇타임)
	} catch (InterruptedException e) {//이터럽트!!!
		e.printStackTrace();
	}
	System.out.println("main end..");
	
}
}
