package com.bit;
import java.text.DateFormat;
import java.util.*;
public class Ex11 {
public static void main(String[] args) {
	Date d=new Date();
	System.out.println(d);
//	String msg=DateFormat
//			.getDateInstance()
//			.
	DateFormat df=DateFormat.getDateInstance();
	String msg=df.format(d);
	System.out.println(msg);
	
//	          static int    SHORT, LONG, FULL, DEFUALT,
	df=DateFormat.getDateInstance(DateFormat.LONG,Locale.KOREA);
	msg=df.format(d);
	System.out.println(msg);
	
}
}
