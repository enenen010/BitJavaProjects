package com.bit;

import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Ex09 extends Frame implements MouseMotionListener{
	Label la;
	public Ex09() {
		Panel p=new Panel();
		p.setLayout(null);
		p.addMouseMotionListener(this);
		
		la=new Label("*");
		la.setSize(35, 35);
		la.setLocation(100, 100);
		p.add(la);
		add(p);
		
		setBounds(100, 100, 200, 200);
		
	}
	public static void main(String[] args) {
		new Ex09().setVisible(true);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		int x=e.getX();
		int y=e.getY();
		System.out.println("드래그 x,y "+x+","+y);
		
		
		la.setLocation(x, y);
		
		System.out.println("드래그");
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		System.out.println("움직");
	}

}
