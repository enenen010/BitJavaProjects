package com.bit;

class MyErr extends Exception{
	MyErr(){
		super("내가 정한 메세지"); //따로 메서드 대신 생성자에 넣어 메세지 주입
	}
}

public class Ex13 {
	
	//런타임 익셉션, 아닌 익셉션 : 
		public static void func(int a, int b) 
		throws ClassNotFoundException{//호출한쪽에 예외를 던진다는 뜻
			if(Double.isInfinite(a/b)) {//throws구현 같은거임
				//이게 국내에서 안좋아하는 에러 만들어 던지기
				//해외에선 시나리오가 에러면 이렇게라도 던짐
				ClassNotFoundException err;
				err=new ClassNotFoundException();
				int su=a/b;	
				throw err;
			}
		}


	public static void main(String[] args) {
	try {
		func(4,0);
	}catch (ArithmeticException e) {
		System.out.println("");
	}catch (ClassNotFoundException e) {
		
	}
	
	}
}
