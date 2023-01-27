package com.bit;
import java.text.SimpleDateFormat;
import java.util.*;

public class Quest01 {
public static void main(String[] args) {
	/*
	 * 100일 계산기(ver 0.1.0)
	 * 년>
	 * 월>
	 * 일>
	 * 0000-01-01에서 100일 뒤는 0000-00-00입니다.
	 * 
	 * */
	
//	//방법1-1. Long타입 숫자에 100일만큼 더해 다시 날짜로바꿔출력
//	Date d=new Date(2022-1900,12,26);
//	long before=d.getTime();
//	before+=1000L*60L*60L*24L*100L;//1000의1초 60초 60분 24시간 
//	Date d2=new Date(before);
//	System.out.println(d);
//	System.out.println(d2);
//	//방법1-2.
//	Calendar cal=new GregorianCalendar(2022,12-1,1);
//	cal.add(Calendar.DATE, 100);
//	System.out.println(d);
//	System.out.println(d2);
	
	//방법2. 
	System.out.println("100일 계산기(ver 0.1.0)");
	Scanner sc=new Scanner(System.in);
	int year;
	int month;
	int date;
	
	while(true) {
		try {
			System.out.print("년>");
			year=sc.nextInt();
			System.out.print("월>");
			month=sc.nextInt();
			System.out.print("일>");
			date=sc.nextInt();
			break;
		}catch(InputMismatchException e) {
			System.out.println("숫자로 입력하여주세요");
			sc=new Scanner(System.in);
			continue;
		}
	}
	
	
	int dayLangth=100;
	
	Date dat=new Date(year-1900,month-1,date);
	
	SimpleDateFormat sdf=new SimpleDateFormat();
	sdf.applyPattern("yyyy-MM-dd");
	String msg=sdf.format(dat);
	
	System.out.print(msg+"에서 "+dayLangth+"일 뒤는 ");
	
	dat.setDate(dat.getDate()+dayLangth-1);//시작날짜포함
	msg=sdf.format(dat);
	System.out.println(msg+"입니다.");
	
	//방법3.
	Calendar before=new GregorianCalendar(year,month,date);
	Calendar after=(GregorianCalendar)before.clone();
	after.add(Calendar.DATE, dayLangth-1);
		
	System.out.print( before.get(Calendar.YEAR)
			+"-"+before.get(Calendar.MONTH)
			+"-"+before.get(Calendar.DATE)
			+"에서 "+dayLangth+"일 뒤는 ");
	System.out.println( after.get(Calendar.YEAR)
			+"-"+after.get(Calendar.MONTH)
			+"-"+after.get(Calendar.DATE)
			+"입니다.");
}
}
