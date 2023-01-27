package com.bit2;
import java.awt.*;
public class Ex05 extends Frame{
	public Ex05(){
		setLayout(null);//디폴트가 있음
		
		Button btn1=new Button();
		btn1.setLabel("btn1");
		btn1.setSize(100,100);
		btn1.setLocation(50,50);
		add(btn1);
		
		
		setLocation(200,200);
		setSize(400,200);
		setResizable(false);
		setVisible(true);
	}
public static void main(String[] args) {
	new Ex05();
}
}
