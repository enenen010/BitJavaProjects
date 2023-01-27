package com.bit;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Ex07 extends Frame implements WindowListener{
public Ex07() {
	addWindowListener(this);
	setBounds(100,100,400,400);
}
public static void main(String[] args) {
	new Ex07().setVisible(true);
}

/////////////////////////

@Override
public void windowOpened(WindowEvent e) {
	System.out.println("열렸다");
}

@Override
public void windowClosing(WindowEvent e) {
	System.out.println("닫기버튼");
	this.dispose();//windowClosed 발동(정상종료)
	System.exit(0);//
}

@Override
public void windowClosed(WindowEvent e) {
	System.out.println("windowClosed");
	//후행작업
}

@Override
public void windowIconified(WindowEvent e) {
	System.out.println("최소화");
}

@Override
public void windowDeiconified(WindowEvent e) {
	System.out.println("최소화반대");
}

@Override
public void windowActivated(WindowEvent e) {
	System.out.println("활성화");
}

@Override
public void windowDeactivated(WindowEvent e) {
	System.out.println("비활성화");
}
}
