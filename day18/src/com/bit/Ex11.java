package com.bit;

import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

public class Ex11 extends Frame implements TextListener{
	public Ex11() {
		Panel p=new Panel();
		TextField tf=new TextField();
		tf.addTextListener(this);
		p.add(tf);
		add(p);
		setBounds(500,100,300,300);
	}
	public static void main(String[] args) {
		new Ex11().setVisible(true);
	}
	
	//텍스트를 가지고 있어야됨
	@Override
	public void textValueChanged(TextEvent e) {
		//e로 tf객체가져와버림
		String msg=((TextField)e.getSource()).getText();
		System.out.println(msg);
	}

}
