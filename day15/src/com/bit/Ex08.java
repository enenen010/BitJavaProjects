package com.bit;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Ex08 {
public static void main(String[] args) {
	Calendar cal=Calendar.getInstance();
	
	int before=cal.get(Calendar.DAY_OF_YEAR);
	
	cal.set(2022, 12-1, 6,0,0,0);//다른 오버로드는 매개변수명 참조
	    //2022년 12월 6일 0시 0분 0초       월은0부터셈
	System.out.println(
			cal.get(Calendar.YEAR)
			+cal.get(Calendar.MONTH)
			+cal.get(Calendar.DATE)
			+cal.get(Calendar.HOUR)
			);
	
	int after=cal.get(Calendar.DAY_OF_YEAR);
	System.out.println(before-after+1);
	//하루 안지나도 1일째로 보니까 +1
	
	//기본적으로 시스템 시간 기준 -> 미국시간 등 조절가능
	
	Calendar cal2=Calendar.getInstance();
	System.out.println(cal2.before(cal));//cal보다 cal2가 전인가
	System.out.println(cal2.after(cal));//   //        후인가
	System.out.println(cal2.compareTo(cal));//전후같음 -1 0 1
}
}
