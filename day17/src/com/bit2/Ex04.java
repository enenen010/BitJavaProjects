package com.bit2;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;

public class Ex04 extends Frame{
	
	public Ex04(){
		LayoutManager lm=new GridBagLayout();
		GridBagConstraints gdc;//쓰기 빡셈
		gdc=new GridBagConstraints();
		setLayout(lm);
		
		gdc.fill=0; //GridBagConstraints.BOTH=꽉채움
		
		//화면이 늘었다 줄어도 배치관리자가 알아서 맞춰주기에
		//배치관리자 쓰는 이유
		Button btn1 = new Button();
		btn1.setLabel("버튼1");// 깨짐 윈도우 ms949라서
		gdc.gridx=0;//위치
		gdc.gridy=0;
		gdc.gridwidth=1;//가로몇칸차지(셀병합)
		gdc.gridheight=1;//세로
		gdc.weightx=1;//가중치 x,y 총합이 1이되야됨 퍼센트(어려움)
		gdc.weighty=1;//가중치: 화면 늘이고 줄일때 늘어나는 비율 가로가 더늘어나거나등
		add(btn1,gdc);
		
		Button btn2 = new Button();
		btn2.setLabel("버튼2");// 깨짐 윈도우 ms949라서
		gdc.gridx=1;
		gdc.gridy=1;
		gdc.gridwidth=1;
		gdc.gridheight=1;
		gdc.weightx=1;
		gdc.weighty=1;
		add(btn2);
		
		Button btn3 = new Button();
		btn3.setLabel("버튼3");// 깨짐 윈도우 ms949라서
		gdc.gridx=1;
		gdc.gridy=1;
		gdc.gridwidth=1;
		gdc.gridheight=1;
		gdc.weightx=1;
		gdc.weighty=1;
		add(btn3);
		
		Button btn4 = new Button();
		btn4.setLabel("버튼4");// 깨짐 윈도우 ms949라서
		gdc.gridx=1;
		gdc.gridy=1;
		gdc.gridwidth=1;
		gdc.gridheight=1;
		gdc.weightx=1;
		gdc.weighty=1;
		add(btn4);
		
		Button btn5 = new Button();
		btn5.setLabel("버튼5");// 깨짐 윈도우 ms949라서
		gdc.gridx=1;
		gdc.gridy=1;
		gdc.gridwidth=1;
		gdc.gridheight=1;
		gdc.weightx=1;
		gdc.weighty=1;
		add(btn5);
		
		Button btn6 = new Button();
		btn6.setLabel("버튼6");// 깨짐 윈도우 ms949라서
		gdc.gridx=1;
		gdc.gridy=1;
		gdc.gridwidth=1;
		gdc.gridheight=1;
		gdc.weightx=1;
		gdc.weighty=1;
		add(btn6);
		
		Button btn7 = new Button();
		btn7.setLabel("버튼7");// 깨짐 윈도우 ms949라서
		gdc.gridx=1;
		gdc.gridy=1;
		gdc.gridwidth=1;
		gdc.gridheight=1;
		gdc.weightx=1;
		gdc.weighty=1;
		add(btn7);
		
		Button btn8 = new Button();
		btn8.setLabel("버튼8");// 깨짐 윈도우 ms949라서
		gdc.gridx=1;
		gdc.gridy=1;
		gdc.gridwidth=1;
		gdc.gridheight=1;
		gdc.weightx=1;
		gdc.weighty=1;
		add(btn8);
		
		Button btn9 = new Button();
		btn9.setLabel("버튼9");// 깨짐 윈도우 ms949라서
		gdc.gridx=1;
		gdc.gridy=1;
		gdc.gridwidth=1;
		gdc.gridheight=1;
		gdc.weightx=1;
		gdc.weighty=1;
		add(btn9);
		
		Button btn10 = new Button();
		btn10.setLabel("버튼10");// 깨짐 윈도우 ms949라서
		gdc.gridx=1;
		gdc.gridy=1;
		gdc.gridwidth=1;
		gdc.gridheight=1;
		gdc.weightx=1;
		gdc.weighty=1;
		add(btn10);
		
		setSize(500,400);
		setLocation(300,300);
	}
	
public static void main(String[] args) {
	Ex04 me=new Ex04();
	
}
}
