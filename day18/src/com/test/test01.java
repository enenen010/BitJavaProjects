package com.test;

import java.awt.*;
import java.util.*;
import javax.swing.*;

public class test01 extends Frame{
	public test01() {
		CardLayout cl=new CardLayout();
		setLayout(cl);
		GridBagLayout gdc=new GridBagLayout();
		
		Panel[] basePanel= {new Panel(),new Panel()};
		Panel[] p1= {new Panel(),new Panel()};
		Panel[] p2= {new Panel(),new Panel()};
		
		add(basePanel[0]);//메인페이지
		add(basePanel[1]);//입력수정페이지
		basePanel[0].setLayout(new BorderLayout());
		basePanel[1].setLayout(new BorderLayout());
		
		TextArea taMain=new TextArea();
		
		
		basePanel[0].add(p1[0],BorderLayout.NORTH);//메인페이지 위칸
		basePanel[0].add(p1[1],BorderLayout.CENTER);//메인페이지 아래칸
		
		//학번, 검색, 삭제, 상세보기 배치
		TextField tfNum1=new TextField();
		JLabel la1=new JLabel("학번");
		Button btnSelect=new Button("검색");
		Button btnDel=new Button("삭제");
		Button btnDetail=new Button("상세");
		p1[0].setLayout(new FlowLayout());
		p1[0].add(tfNum1);
		p1[0].add(la1);
		p1[0].add(btnSelect);
		p1[0].add(btnDel);
		p1[0].add(btnDetail);
		
		
		
		
		basePanel[1].add(p1[0],BorderLayout.CENTER);
		basePanel[1].add(p1[1],BorderLayout.EAST);
		
		
		for(int i=0;i<5;i++) {
			add(new JButton(""+i));
		}
		
		setBounds(100, 100, 600, 500);
	}
public static void main(String[] args) {
	new test01().setVisible(true);
}
}
