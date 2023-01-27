package com.bit;

import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

import javax.swing.JLabel;

public class Ex03 extends Frame{
	public Ex03() {
		Panel p=new Panel();
		Label la=new Label("한글");
		Font f=new Font("궁서체", Font.BOLD, 40);
		la.setFont(f);
		la.setForeground(new Color(0,255,0));
		la.setBackground(new Color(255,255,0));
		p.setBackground(new Color(255,255,223));
		p.add(la);
		
		TextField tf=new TextField(10);
		tf.setFont(f);
		tf.setEnabled(false);
		tf.setVisible(false);
		tf.setEditable(false);
		
		Button btn=new Button("버튼");
		btn.setEnabled(false);
		btn.setVisible(false);
		
		p.add(tf);
		add(p);
		setBounds(100,100,400,300);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Ex03();
	}
}
