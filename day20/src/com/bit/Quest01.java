package com.bit;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class Quest01 extends Frame implements ActionListener {
	// 컨트롤
	static JButton[] moleBtn;
	static JButton startBtn;
	static JButton endBtn;
	static Label timeLa;
	static Label scoreLa;
	static Thread thr;

	// 변수
	static long startDate;//시작시간저장
	static int score = 0;//점수
	
	static int maxTime = 100;//제한시간
	static int interver = 500;//두더지출몰정도
	
	static JButton beforeBtn;//이전두더지
	
	static final ImageIcon moleImg = new ImageIcon("./Button_Image/mole.png");
	static final ImageIcon holeImg = new ImageIcon("./Button_Image/Hole.png");

	//게임초기화 및 준비: 경과기준시간, 점수 초기화 
	public static void Init() {
		startDate = new Date().getTime();
		score=0;
		scoreLa.setText(Integer.toString(score));
		timeLa.setText(Integer.toString(maxTime/10));
	}
	
	//게임 쓰레드 생성 메서드
	public Thread moleGemeThread(int maxTime, int interver) {
		Thread thr = new Thread(new Runnable() {
			@Override
			public void run() {
				Init();

				int su = maxTime;

				while (su != 0) {
					int realTime = (int) ((new Date().getTime()) - startDate) / 100;
					su = (maxTime - realTime) / 10;
					timeLa.setText(Integer.toString(su));

					int a = new Random().nextInt(16);
					
					if (beforeBtn != null) {
						moleBtn[a].setIcon(moleImg);
						beforeBtn.setIcon(holeImg);
						beforeBtn = moleBtn[a];
					} else {
						moleBtn[a].setIcon(moleImg);
						beforeBtn = moleBtn[a];
					}
					try {
						Thread.sleep(interver);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		return thr;
	}

	//폼 디자인
	public Quest01() {

		Panel p1 = new Panel();
		p1.setLayout(new GridLayout(4, 4));
		moleBtn = new JButton[16];
		for (int i = 0; i < moleBtn.length; i++) {
			moleBtn[i] = new JButton();
			moleBtn[i].setIcon(holeImg);
			moleBtn[i].setLabel("moleBtn");
			p1.add(moleBtn[i]);
			moleBtn[i].addActionListener(this);
		}

		Panel p2 = new Panel();
		startBtn = new JButton("Start");
		endBtn = new JButton("End");
		p2.setLayout(new GridLayout(2, 1));
		startBtn.addActionListener(this);
		endBtn.addActionListener(this);
		p2.add(startBtn);
		p2.add(endBtn);

		Panel p3 = new Panel();
		timeLa = new Label("Time");
		p3.setLayout(new FlowLayout());
		p3.add(timeLa);

		Panel p4 = new Panel();
		scoreLa = new Label("Score:");
		p4.setLayout(new FlowLayout());
		p4.add(scoreLa);

		setLayout(new BorderLayout());
		add(p1, BorderLayout.CENTER);
		add(p2, BorderLayout.EAST);
		add(p3, BorderLayout.NORTH);
		add(p4, BorderLayout.SOUTH);

		setBounds(100, 100, 600, 700);
	}

	public static void main(String[] args) {
		new Quest01().setVisible(true);
		
		Init();
	}
	
	//버튼제어
	@Override
	public void actionPerformed(ActionEvent e) {
		if (((JButton) e.getSource()).getLabel() == "moleBtn") {// 두더지버튼
			if (((JButton) e.getSource()).getIcon().equals(moleImg)) {
				((JButton) e.getSource()).setIcon(holeImg);
				score++;
			} else {
				score -= 2;
			}

			scoreLa.setText(Integer.toString(score));
		}

		if (((JButton) e.getSource()).getLabel() == "Start") {// 시작버튼
			Init();
			thr=moleGemeThread(maxTime,interver);
			thr.start();
		}
		
		if (((JButton) e.getSource()).getLabel() == "End") {// 종료버튼
			thr.stop();
		}
	}
}

