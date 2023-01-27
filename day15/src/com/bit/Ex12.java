package com.bit;

import java.text.SimpleDateFormat;
import java.util.*;

public class Ex12 {
public static void main(String[] args) {
//	Direct Known Subclasses:
//	SimpleDateFormat
//    static int    SHORT, LONG, FULL, DEFUALT, 미디엄 정해진게 아닌 사용자 정의 포멧	
	Date d=new Date();
	SimpleDateFormat sdf;
	sdf=new SimpleDateFormat();
	
	sdf.applyPattern("yyyy-MM-dd");
	String msg=sdf.format(d);
	System.out.println(msg);
	
	
	
	d=new Date(2022-1900,12-1,6,12,0,0);
	sdf.applyPattern("yy-M-d hh:mm:ss");//06이냐 6이냐 
	msg=sdf.format(d);
	System.out.println(msg);
}
}
