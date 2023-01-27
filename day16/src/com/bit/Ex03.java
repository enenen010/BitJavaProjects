package com.bit;

import java.util.List;
import java.util.LinkedList;

public class Ex03 implements Runnable{
public static void main(String[] args) {
	Thread thr=Thread.currentThread();
	String name=thr.getName();
	System.out.println(name+" start...");
	
	//할일을 가지고 있는게 내 객체니까
	Thread thr2=new Thread(new Ex03());//쓰레드 생성법 할일=run()을 가진 객체를 넣어줌
	thr2.start();
	List list=new LinkedList();
	for(int i=0;i<10000;i++) {
		list.add(i);
	}
	System.out.println(name+" end...");
}

public void run() {
	Thread thr=Thread.currentThread();
	String name=thr.getName();
	System.out.println(name+" start...");
	System.out.println(name+" end...");
}
}
