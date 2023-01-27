package com.bit2;
import javax.swing.*;
import java.awt.*;
public class Quest extends Frame{
	
	public Quest() {
		
		
		///****************////////////////////
		Panel p1=new Panel();
		
		
		gdc1.fill=0; //GridBagConstraints.BOTH=꽉채움
		
		TextField tf1=new TextField();
		add(tf1);
		////////////////////
		
		Label la1=new Label();
		add(la1);
		////////////////////
		
		
		Button btnPlus = new Button();
		btnPlus.setLabel("+");// 깨짐 윈도우 ms949라서
		add(btnPlus);
		
		Button btn0 = new Button();
		btn0.setLabel("0");// 깨짐 윈도우 ms949라서
		add(btn0);
		
		Button btnCom = new Button();
		btn0.setLabel(".");// 깨짐 윈도우 ms949라서
		add(btnCom);
		
		Button btnEqu = new Button();
		btnEqu.setLabel("=");// 깨짐 윈도우 ms949라서
		add(btnEqu);
		
		///////////////////////////////
		
		
		
		Button btn1 = new Button();
		btn1.setLabel("1");// 깨짐 윈도우 ms949라서
		add(btn1);
		
		Button btn2 = new Button();
		btn2.setLabel("2");// 깨짐 윈도우 ms949라서
		add(btn2);
		
		Button btn3 = new Button();
		btn3.setLabel("3");// 깨짐 윈도우 ms949라서
		add(btn3);
		
		Button btnM = new Button();
		btnM.setLabel("3");// 깨짐 윈도우 ms949라서
		add(btnM);
		/////////////////////////////
		
		Button btn4 = new Button();
		btn4.setLabel("4");// 깨짐 윈도우 ms949라서
		add(btn4);
		
		Button btn5 = new Button();
		btn5.setLabel("5");// 깨짐 윈도우 ms949라서
		add(btn5);
		
		Button btn6 = new Button();
		btn6.setLabel("6");// 깨짐 윈도우 ms949라서
		add(btn6);
		
		Button btnN = new Button();
		btnN.setLabel("/");// 깨짐 윈도우 ms949라서
		add(btnN);
		///////////////////////////////////
		
		Button btn7 = new Button();
		btn7.setLabel("7");// 깨짐 윈도우 ms949라서
		add(btn7);
		
		Button btn8 = new Button();
		btn8.setLabel("8");// 깨짐 윈도우 ms949라서
		add(btn8);
		
		Button btn9 = new Button();
		btn9.setLabel("9");// 깨짐 윈도우 ms949라서
		add(btn9);
		
		Button btnG = new Button();
		btnG.setLabel("*");// 깨짐 윈도우 ms949라서
		add(btnG);
		
		
		
		
		
		
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		///****************////////////////////
		
		
		
		
		
		Panel p2=new Panel();
		Button btn2=new Button("2");
		p2.add(btn2);
		
		
		add(p1);
		add(p2);
		
		setLayout(new FlowLayout());
		setSize(400,400);
		setLocation(100,100);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Quest();
	}
}
