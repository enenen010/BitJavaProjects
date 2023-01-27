package com.bit2;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

public class Ex07 extends Frame{

	public Ex07() {
		Panel p=new Panel();
		
		Button btn1=new Button("버튼1");
//		btn1.setLabel("버튼1");
//		btn1.enable(false); //안보임
		btn1.setEnabled(false);//사용불가
		p.add(btn1);
		
		/////////////////////////////////////
		
		JButton btn2=new JButton("버튼2");
		btn2.setEnabled(false);
		btn2.setText("수정");
		
		//그림을 넣기위한 멀고먼 과정
		byte[] arr = new byte[1611];
		File f = new File("img01.jpg");
		InputStream is = null;
		try {
			is = new FileInputStream(f);
			for (int i = 0; i < arr.length; i++) {
				arr[i] = (byte)is.read();
			}
			if(is!=null)is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		Icon defaultIcon=new ImageIcon(arr);
		btn2.setIcon(defaultIcon);//그림을넣을수있어요~
		p.add(btn2);
		
		
		/////////////////////////////////////
		
		
		TextField tf=new TextField(10);//픽셀no, 10글자사이즈(뭔폰튼진모름)
		tf.setText("ab");
		tf.setEchoChar('#');//화면상의 표현을 #으로 대체
		p.add(tf);
		
		
		//여러줄 디폴트에서 작아지진 않는데 커지긴함 
		//세로로5 가로로10 글자
		TextArea ta=new TextArea("",5,10,TextArea.SCROLLBARS_BOTH);
		p.add(ta);
		
		
		/////////////////////////////////////
		
//		Checkbox ch1=new Checkbox();
//		ch1.setLabel("item1");//라벨: 클릭되는 글자
//		Checkbox ch2=new Checkbox();
//		ch2.setLabel("item2");
//		ch2.setState(true);
//		Checkbox ch3=new Checkbox();
//		ch3.setLabel("item3");
//		p.add(ch1);
//		p.add(ch2);
//		p.add(ch3);
		
		
		CheckboxGroup cbg=new CheckboxGroup();
		Checkbox ch1=new Checkbox("item1",false,cbg);
		Checkbox ch2=new Checkbox("item2",false,cbg);
		ch2.setState(true);
		Checkbox ch3=new Checkbox("item3",false,cbg);
		p.add(ch1);
		p.add(ch2);
		p.add(ch3);
		
		/////////////////////////////////////
		
		Choice cho=new Choice();
		cho.addItem("item1");
		cho.addItem("item1");
		cho.addItem("item1");
		cho.addItem("item1");
		cho.select("item3");
		p.add(cho);
		
		//                     ↓ 초이스와 큰차이점 다중선택 가능
		List list=new List(5,true);
		list.add("item1");
		list.add("item2");
		list.add("item3");
		list.add("item4");
		list.select(2);
		p.add(list);
		
		
		Label la=new Label("aaaa");
		la.setText("bbb");
		p.add(la);
		
//		//그림가능
//		JLabel la2=new JLabel("aaaa");
//		la2.setText("bbb");
//		la2.setIcon(defaultIcon);
//		p.add(la);
		
		add(p);
		setLocation(100,100);
		setSize(500,400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex07();
	}
}
