package com.bit;

import java.awt.*;

public class Ex05 extends Frame{
	//메뉴는 창(window)에 귀속
	public Ex05() {
		MenuBar mb=new MenuBar();
		Menu m1=new Menu("메뉴1");
		m1.add("1-1");
		//
		MenuItem mi1=new MenuItem("1-2");
		m1.add(mi1);
		MenuItem mi2=new CheckboxMenuItem("1-2(ch)");
		m1.add(mi2);
		//
		Menu m3=new Menu("1-3");
		m3.add("1-3-1");
		m1.add(m3);
		
		//////////
		Menu m2=new Menu("메뉴2");
		m2.add("2-1");
		
		
		mb.add(m1);
		mb.add(m2);
		setMenuBar(mb);
		
		
		setBounds(100, 100, 500, 300);
	}
public static void main(String[] args) {
	new Ex05().setVisible(true);
}
}
