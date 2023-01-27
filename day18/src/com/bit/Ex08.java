package com.bit;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//공통이벤트: 마우스이벤트 or 키보드이벤트
public class Ex08 extends Frame implements MouseListener, ContainerListener{
	Panel p=new Panel();
	JButton btn=new JButton();
	public Ex08() {
		p.addContainerListener(this);
		
		p.add(btn);
		add(p);
		btn.addMouseListener(this);
		setBounds(600,100,300,300);
	}
public static void main(String[] args) {
	new Ex08().setVisible(true);
}
@Override
public void mouseClicked(MouseEvent e) {
	int x=e.getX();
	int y=e.getY();
	System.out.println("클릭 x,y "+x+","+y);//요좌표 이벤트객체기준(상대좌표)
	
	int x2=e.getXOnScreen();
	int y2=e.getYOnScreen();
	System.out.println("클릭 x,y "+x2+","+y2);//요좌표 화면기준
	System.out.println("클릭");
	//컴포넌트위에서 일정시간안에 누로고 떼는 2동작이 발생한 상태
	
	Label la=new Label("추가");
	la.addMouseListener(this);
	p.add(la);
	
	//하나 안되면 셋중골라
	validate();//검사
	revalidate();//재검사
	repaint();//다시그림 
}
@Override
public void mousePressed(MouseEvent e) {
	System.out.println("누름");
}
@Override
public void mouseReleased(MouseEvent e) {
	System.out.println("[눌린다음]올라옴");
}
@Override
public void mouseEntered(MouseEvent e) {
	System.out.println("컴포넌트 위로 올라옴");
	if(e.getSource()!=btn){
		System.out.println("label위로");
		Label la=(Label) e.getSource();
		p.remove(la);
		//자동 새로 안그려주는 이유
		//바로자리바뀌면 안필요한것도 다없어지니 필요할때 다시그리자
		validate();
	}
}
@Override
public void mouseExited(MouseEvent e) {
	System.out.println("컴포넌트 벗어남");
}
@Override
public void componentAdded(ContainerEvent e) {
	System.out.println("라벨 추가됨");
	validate();
}
@Override
public void componentRemoved(ContainerEvent e) {
}
}
