package com.bit2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.Panel;

import javax.swing.JButton;

public class Ex06 extends Frame{
	
	//작업영역
	public Ex06(){
		//레이아웃 여러개!! 패널당 1개  배치관리자
		Panel p=new Panel();//디폴트가 플로우
		p.setLayout(new FlowLayout());
		
		JButton btn1=new JButton();//얜한글잘나옴 결국os문제
		btn1.setLabel("버튼1");
		p.add(btn1);
		
		
		Panel p2=new Panel();//디폴트가 플로우
		p2.setLayout(new BorderLayout());
		
		JButton btn2=new JButton();//얜한글잘나옴 결국os문제
		btn2.setLabel("버튼2");
		p2.add(btn2,BorderLayout.EAST);
		
		
		setLocation(100,100);
		setSize(400,200);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Ex06();
	}
}
