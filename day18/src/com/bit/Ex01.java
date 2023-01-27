package com.bit;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.TextField;

public class Ex01 extends Frame{
	public Ex01(){
		LayoutManager lm=new BorderLayout();
		setLayout(lm);
		
		
		
		
		
		Panel p=new Panel();
		p.setLayout(new GridBagLayout());
		GridBagConstraints gdc=new GridBagConstraints();
		gdc.fill=GridBagConstraints.BOTH;
		gdc.gridx=1;
		gdc.gridy=1;
		gdc.gridwidth=1;
		gdc.gridheight=1;
		gdc.weightx=1;
		gdc.weighty=1;
		
//		String[] msg={
//			"7","8","9","*",
//			"4","5","6","/",
//			"1","2","3","-",
//			"+","0",".","=",
//			};
//		for(int i=0;i<16;i++) {
//			p.add(new Button(msg[i]));
//		}
		
		
		String[][] msg={
				{"7","8","9","+"},
				{"4","5","6","/"},
				{"1","2","3","="},
				{"0","."}
				};
		for(int i=0;i<4;i++) {
			String[] cols=msg[i];
			for(int j=0; j<cols.length;j++) {
				gdc.gridx=j;
				gdc.gridy=1;
				if(i==2&&j==3)gdc.gridheight=2;
				else gdc.gridheight=1;
				if(i==3&&j==0)gdc.gridwidth=2;
				else gdc.gridwidth=1;
				if(i==3&&j==1)gdc.gridx=2;
				p.add(new Button(cols[j]),gdc);
			}
		}
		
		
//		add(new TextField(),BorderLayout.NORTH);
//		add(p,BorderLayout.CENTER);
		setLocation(100,100);
		setSize(500,400);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Ex01();
	}
}
