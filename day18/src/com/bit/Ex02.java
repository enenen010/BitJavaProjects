package com.bit;
import java.awt.*;
public class Ex02 extends Frame{
public static void main(String[] args) {
	Ex02 me=new Ex02();
	
	
//	이사이즈 여러번 필요할때
	Dimension dim=new Dimension();
	dim.width=300;
	dim.height=200;
//	setLocation(100,100);
//	setSize(500,400);
	me.setBounds(100,100,400,400);
	
	//해상도 알아내기
	Toolkit tool=Toolkit.getDefaultToolkit();//윈도우 정보 인스턴스 반환
	Dimension dim2=tool.getScreenSize();
	System.out.println(dim2);
	int w=dim2.width/2-dim.width/2;
	int h=dim2.height/2-dim.height/2;
	me.setBounds(w,h,dim.width,dim.height);
	me.setVisible(true);
}
}
