package com.bit;

import java.awt.*;
import java.awt.*;

import javax.swing.*;

public class MainLoot extends Frame{
	
	public MainLoot() {
		
		
		
		Panel pn=new Panel();
		JLabel la=new JLabel("흑과백 게임");
		pn.add(la);
		
		Panel pc=new Panel();
		
		pc.setLayout(new GridLayout(3,2));
		pc.add(new JButton("방1"));
		pc.add(new Label());
		pc.add(new Label());
		pc.add(new Label());
		pc.add(new Label());
		pc.add(new Label());
		
		Panel pe=new Panel();
		pe.setLayout(new GridLayout(5,1));
		pe.add(new JLabel("방이름:"));
		TextField roomNameTf=new TextField();
		pe.add(roomNameTf);
		pe.add(new JButton("방만들기"));
		pe.add(new Label());
		pe.add(new JButton("종료"));
		
		setLayout(new BorderLayout());
		add(pn,BorderLayout.NORTH);
		add(pc,BorderLayout.CENTER);
		add(pe,BorderLayout.EAST);
		
		setBounds(100,100,500,400);
	}
	
public static void main(String[] args) {
	new MainLoot().setVisible(true);
}
}
