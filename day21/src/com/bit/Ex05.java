package com.bit;

class Lec05 extends Thread{
	static int sum;
	int su1,su2;
	static Object key=new Object();
	
	public Lec05(int a,int b,Object key) {
		su1=a;
		su2=b;
		//쓰레드에서 가장 문제를 많이 일으키는게 동기화
		//중요한건 키는 내가 중복을 피하고싶은범위(객체,클래스)내에서 유일해야 한다는것
		//키는 객체기만하면 어떤 타입이든 상관없음(Object이하 모두)
		this.key=key;
	}
	
//	메서드에 선언하면 무조건 this
//	메서드에 static안붙이면 객체마다 하나씩생기므로 this가 서로 달라져
//	동기화 불가
//	static붙으면 static공간에 임의의 키가 자동생성
//	public synchronized static void hap(int a) {
//		sum=sum+a;
//	        sum+a-를 실행하고 sum=을 실행함 
//	        sum+a실행하고 뺏겼다 다시오면 다른값을 sum=하는거임
//		     동기화없으면
//	}
	
//	자료구조엔 vector빼고 다 동기화 되어있음
//	
	public static void hap(int a) {
		
		int tot=sum+a;
		sum=tot;
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
	
	@Override
	public void run() {
		Ex05 key=new Ex05();
		System.out.println(su1+"+"+su2+"="+sum);
	}
}

public class Ex05 {
public static void main(String[] args) {
//	Lec05 lec1=new Lec05(1,50);
//	Lec05 lec2=new Lec05(50,100);
	Lec05 lec1=new Lec05(1,500);
	Lec05 lec2=new Lec05(500,1000);
//	lec1.run();
//	lec2.run();
	lec1.start();
	lec2.start();
}
}
