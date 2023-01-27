package com.bit;

import java.util.*;

public class Ex09 {
public static void main(String[] args) {
	//실제 우리 컴퓨터 달력 GregorianCalendar
	//1970년 1월 1일 이후 날짜데이터
	//부모타입으로 받는 클래스는 부모랑 똫같이 쓰면됨
	Calendar cal=new GregorianCalendar(2022,12-1,6,18,0,0);//GregorianCalendar는 완전한 클래스
	System.out.println(cal);
	
	System.out.println(cal.get(Calendar.YEAR));
	System.out.println(cal.get(Calendar.MONTH));
	System.out.println(cal.get(Calendar.DATE));
	System.out.println(cal.get(Calendar.HOUR));//시분초에따라 예약등에선 영향
	
	//cal.add(field, amount); 필드별 설정
}
}
