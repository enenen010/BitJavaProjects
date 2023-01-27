package com.bit;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Ex04 extends Frame{
	//Ex04 me=new MyCanvas();
class MyCanvas extends Canvas{
	//벡터방식
	//특징: 아무리 크기조절같은거 해도 꺠짐이 없음
	//(작은점으로 이루어진거 아님)=안정적
	//불편하고 표현이 힘듬 , 크기가 겁나큼(ex원그릴때 끝없이 많은 직선을 그림)
	@Override
	public void paint(Graphics g) {
		char[] arr="abc".toCharArray();
		g.drawChars(arr, 0, arr.length, 100, 100);
		g.drawLine(100, 100, 200, 200);
		g.setColor(Color.RED);
		g.drawRect(200, 200, 100, 100);
		g.setColor(Color.BLUE);
		g.drawOval(300, 300, 200, 200);
		g.drawArc(100, 100, 100, 100, 45, 180);//45도에서 180도 원
		
		
		//갭두는법 빈라벨에 폰트넣어서 두기
		
//		Toolkit tool=Toolkit.getDefaultToolkit();
//		Image img=tool.createImage("logo.jpg");
//		g.drawImage(img, 100,100, observer);
//		super.paint(g);
	}
}


public Ex04() {
	Canvas can=new MyCanvas();
	add(can);
	
	setBounds(100, 100, 500, 500);
	setVisible(true);
	
}
public static void main(String[] args) {
	new Ex04();
}
}
