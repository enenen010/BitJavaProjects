package com.bit;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Ex10 extends Frame implements KeyListener{
	static Label la;
	public Ex10() {
	Panel p=new Panel();
	la= new Label();
	TextField tf=new TextField(10);
	tf.addKeyListener(this);
	p.add(tf);
	add(p);
	
	setBounds(100,100,500,300);
	
	}
	
	public static void main(String[] args) throws InterruptedException {
		new Ex10().setVisible(true);
		while(true) {
			Thread.sleep(1000);
			la.setBounds(100, 30, 35, 35);
		}
	}
	
	//포커스가갈수있는 객체만 keyListener가능:키보드,초이스, 버튼 등  패널x
	
	@Override
	public void keyTyped(KeyEvent e) {
		char ch=e.getKeyChar();
		int su=e.getKeyCode();
		System.out.println("문자입력시(값의전달)"+ch+","+su);
	}
	
	//값전달 한박자 늦음 
	@Override
	public void keyPressed(KeyEvent e) {
		char ch=e.getKeyChar();
		int su=e.getKeyCode();
		System.out.println("눌렸고(시간연속)"+ch+","+su);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("올라옴");
		
		char ch=e.getKeyChar();
		int su=e.getKeyCode();
		
		int x=la.getX();
		int y=la.getY();
		System.out.println("클릭 x,y "+x+","+y);
		
		if(su==39) {
			la.setLocation(x+10, y);
		}else if(su==37) {
			la.setLocation(x-10, y);
		}else if(su==38) {
			la.setLocation(x, y-10);
		}else if(su==40) {
			la.setLocation(x, y+10);
		}
		
		
	}

}
