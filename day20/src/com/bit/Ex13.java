package com.bit;

import java.awt.Frame;
import java.awt.Label;
import java.util.Date;
import java.util.Scanner;

//총 3개 쓰레드 동작
//1.main
//2.UI Frame쓰레드
//3.Thread 객체 쓰레드

class Lec13 extends Frame implements Runnable{
	Label la=new Label();
	public Lec13() {
		add(la);
		setBounds(100, 100, 300, 100);
		setVisible(true);
	}
	public void run() {
		while(true) {
			la.setText(new Date().toString());
		}
	}
}

public class Ex13 {
public static void main(String[] args) {
	Lec13 ti=new Lec13();
	Thread thr=new Thread(ti);
	Scanner sc=new Scanner(System.in);
	while(true) {
		System.out.print("1.시작 2.멈춤 3.재시작 4.종료 0.끝>");
//		IO는 한파일을 작업할때 2개이상 스트림 연결 못함, 쓰다가 끼어들면 망가짐
//		아래의 기능은 너무 강함 IO close 되기전에 stop된다면? 
//		쓰레드 제어의 가장 막강한 기능들
		int input=sc.nextInt();
		if(input==0) break;
		if(input==1) thr.start();//단방향(돌아올 수 없음)
		if(input==2) thr.suspend();//쌍방향(갔다가)
		if(input==3) thr.resume();//쌍방향(온다)
		if(input==4) thr.stop();//단방향:얘는 바로 죽여버려서 후행작업의 여지가 없음
//		이렇게 안쓸려면? 프로그램적으로 제어하라 후행작업
//		IO일반적으로는 다하고 
//		어차피 쓰레드 작업 웹에서 다해줌 해주는 프로그램 있음 웹서비스 서버프로그램에서 다해줌
//		파일 가져오는 것도 알아서 해줌(IO) 결국 웹이 어떻게 동작하는지 이해하려고 이거 하는거임
//		플러스 알파를 하면 자바로 서버프로그램도 만들수 있지만 형평없을 거임 대신 어떻게 동작하는지는 얼추 알겠지
//		그래서 자료구조까지해서 세그먼트(우리가 할일은 없지만 이해엔도움이 되는 뒷부분)
		
	}
}
}
