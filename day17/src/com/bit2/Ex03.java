package com.bit2;

import java.awt.*;

public class Ex03 extends Frame {
	static CardLayout cl;
	public Ex03() {
		// 배치관리자
		
		LayoutManager lm;
		
		//1.
//		lm=new FlowLayout();// 플로우로자름,가운데정렬
		lm=new GridLayout(2,1);// 그리드로자름, 세로가 더 우선
		
		//2.
		//add(btn1,"east") "center"등  위치지정 안넣는것도됨
		//BorderLayout.EAST 상수로 편하게
//		lm=new BorderLayout();//많이사용
		
		//3.
		cl=new CardLayout();//화면전환(다가지고있다바꿈-마치카드뭉치)
		
		
		// 앞에건 안드로이드나 다른데서도 사용하는 레이아웃
		// 이건 여기선 유용하지만 awt, swing에서만 쓰는 레이아웃
		// 열심히 하지마

		// 4.
		
		
		
		
//		setLayout(lm);
//		setLayout(cl);

		Button btn1 = new Button();
		btn1.setLabel("버튼1");// 깨짐 윈도우 ms949라서
		btn1.setSize(1000,1000);//써도 소용없음 배치관리자가 조절
		add(btn1);
		Button btn2 = new Button();
		btn2.setLabel("버튼2");// 깨짐 윈도우 ms949라서
		add(btn2);
		Button btn3 = new Button();
		btn3.setLabel("버튼3");// 깨짐 윈도우 ms949라서
		add(btn3);
		Button btn4 = new Button();
		btn4.setLabel("버튼4");// 깨짐 윈도우 ms949라서
		add(btn4);
		Button btn5 = new Button();
		btn5.setLabel("버튼5");// 깨짐 윈도우 ms949라서
		add(btn5);
		Button btn6 = new Button();
		btn6.setLabel("버튼6");// 깨짐 윈도우 ms949라서
		add(btn6);

		setSize(300, 300);
		setLocation(200, 200);
	}

	public static void main(String[] args) throws InterruptedException {
		// 1.ui 컴포넌트뭐있나 (기능, 특징)
		// 2.어떻게 배치할것인가(배치관리자)
		Ex03 me = new Ex03();
		me.setVisible(true);
		
		for(int i=0;i<10;i++) {
			Thread.sleep(1000);
			cl.next(me);
		}
	}
}
