package com.bit;

class LecTe01 extends Thread{
	static int sum;
	int su1,su2;
	static Object key=new Object();
	
	public LecTe01(int a,int b) {
		su1=a;
		su2=b;
	}
	
	public static void hap(int su1,int su2) {
		
		for (int i = su1; i < su2; i++) {
			//key를 명세해 사용하는 동기화
			synchronized(key) {
				int tot=sum+i;
				sum=tot;
			}
			
		}
		
	}
}

public class test01 {
	public static void main(String[] args) {

		Lec05 lec1=new LecTe01(1,500);
		Lec05 lec2=new LecTe01(500,1000);

		lec1.start();
		lec2.start();
	}
}
