package com.bit;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;


//class winL implements WindowListener{
//	WindowListener eve;
//	
//}

public class Ex16 extends JFrame{
public Ex16() {
	//1.
	//끄는거 하나하려고 윈도우리스너? 너무 많아
	//위쪽에 클래스 새로선언해서 오버라이딩 받으면 너무많아..
	//누가 어디다 클래스형태로 만들어 놨으면 좋겠다
	// ...Adapter() !!! 다 오버라이딩 안해도 되게 클래스형태!!
	
//	WindowAdapter eve=new WindowAdapter() {
//		@Override
//		public void windowClosing(WindowEvent e) {
//			super.windowClosing(e);
//		}
//	}; 
//	addWindowListener(eve);
	
	
	//JFrame는 끄는 기능 그냥 만들어놨다(살짝비정상종료느낌)
	//그래도 프레임은 awt많이 씀 운영체제에 종속적인게 나아서 
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
	setBounds(100,100,200,300);
}
public static void main(String[] args) {
	new Ex16().setVisible(true);
}
}
