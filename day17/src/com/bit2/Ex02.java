package com.bit2;

import java.awt.Frame;

/*
 * 버튼그리는등 할거 많아서 왠만하면 상속해서 쓰는데
 * 만약 후순위로 밀렸다
 */

public class Ex02 {
public static void main(String[] args) {
	Frame f=new Frame();
	f.setVisible(true);
	f.setSize(500,400);
	f.setLocation(200,200);//단위픽셀
}
}
