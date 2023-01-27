package com.bit;

public class Ex04 {

	public static void main(String[] args) throws CloneNotSupportedException 
	implements Cloneable{
		Object obj = new Object();
		
		
		Ex04 me = new Ex04();
		Object you = me;
		Ex04 you2 = (Ex04)you;
		
		Ex04 you3 = (Ex04)me.clone();//원래는 안됨, cloneAble인터페이스 상속해야가능 그 자체로 의미가 있다
		System.out.println(you3==me);
		
		int[] arr= {1,3,5,7,9};
		int[] arr2= arr.clone();
		System.out.println(arr==arr2);
	}

}
